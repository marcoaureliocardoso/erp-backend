package br.ufes.sead.erp.financial.fest.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.exceptions.DatabaseException;
import br.ufes.sead.erp.exceptions.ResourceNotFoundException;
import br.ufes.sead.erp.financial.fest.entities.BondEventReminder;
import br.ufes.sead.erp.financial.fest.entities.BondEventReminderNote;
import br.ufes.sead.erp.financial.fest.repositories.BondEventReminderRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BondEventReminderService {

    private final BondEventReminderRepository bondEventRepository;

    public BondEventReminderService(BondEventReminderRepository bondEventRepository) {
        this.bondEventRepository = bondEventRepository;
    }

    public List<BondEventReminder> findAll() {
        return bondEventRepository.findAll();
    }

    public BondEventReminder findById(Long id) {
        Optional<BondEventReminder> bondEvent = bondEventRepository.findById(id);
        return bondEvent.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public BondEventReminder save(BondEventReminder bondEventReminder) {
        return bondEventRepository.save(bondEventReminder);
    }

    public void deleteById(Long id) {
        try {
            if (!bondEventRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            bondEventRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(BondEventReminder bondEventReminder) {
        try {
            if (!bondEventRepository.existsById(bondEventReminder.getId()))
                throw new ResourceNotFoundException(bondEventReminder.getId());

            bondEventRepository.delete(bondEventReminder);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public BondEventReminder update(Long id, BondEventReminder bondEventReminder) {
        try {
            BondEventReminder bondEventEntityReference = bondEventRepository
                    .getReferenceById(id);

            bondEventEntityReference.setEventType(bondEventReminder.getEventType());
            bondEventEntityReference.setEventReminderDate(bondEventReminder.getEventReminderDate());

            return bondEventRepository.save(bondEventEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public BondEventReminder updateNote(Long id, BondEventReminder bondEventReminder) {
        try {
            BondEventReminder bondEventEntityReference = bondEventRepository.getReferenceById(id);

            BondEventReminderNote newNote = bondEventReminder.getNote();
            
            if (bondEventEntityReference.getNote() == null) {
                bondEventEntityReference.setNote(new BondEventReminderNote(newNote.getContent(), bondEventEntityReference));
            } else {
                bondEventEntityReference.getNote().setContent(newNote.getContent());
            }

            return bondEventRepository.save(bondEventEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public List<BondEventReminder> findOverdue() {
        LocalDate today = LocalDate.now();
        return bondEventRepository.findOverdue(today);
    }
}
