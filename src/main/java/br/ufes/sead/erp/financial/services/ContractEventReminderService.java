package br.ufes.sead.erp.financial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.ContractEventReminder;
import br.ufes.sead.erp.financial.repositories.ContractEventReminderRepository;
import br.ufes.sead.erp.financial.services.exceptions.DatabaseException;
import br.ufes.sead.erp.financial.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContractEventReminderService {

    @Autowired
    private ContractEventReminderRepository contractEventRepository;

    public List<ContractEventReminder> findAll() {
        return contractEventRepository.findAll();
    }

    public ContractEventReminder findById(Long id) {
        Optional<ContractEventReminder> contractEvent = contractEventRepository.findById(id);
        return contractEvent.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ContractEventReminder save(ContractEventReminder contractEventReminder) {
        return contractEventRepository.save(contractEventReminder);
    }

    public void deleteById(Long id) {
        try {
            if (!contractEventRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            contractEventRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(ContractEventReminder contractEventReminder) {
        try {
            if (!contractEventRepository.existsById(contractEventReminder.getId()))
                throw new ResourceNotFoundException(contractEventReminder.getId());

            contractEventRepository.delete(contractEventReminder);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ContractEventReminder update(Long id, ContractEventReminder contractEventReminder) {
        try {
            ContractEventReminder contractEventEntityReference = contractEventRepository
                    .getReferenceById(id);

            contractEventEntityReference.setEventType(contractEventReminder.getEventType());
            contractEventEntityReference.setEventReminderDate(contractEventReminder.getEventReminderDate());

            return contractEventRepository.save(contractEventEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
