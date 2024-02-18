package br.ufes.sead.erp.financial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Grantor;
import br.ufes.sead.erp.financial.repositories.GrantorRepository;
import br.ufes.sead.erp.financial.services.exceptions.DatabaseException;
import br.ufes.sead.erp.financial.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GrantorService {

    @Autowired
    private GrantorRepository grantorRepository;

    public List<Grantor> findAll() {
        return grantorRepository.findAll();
    }

    public Grantor findById(Long id) {
        Optional<Grantor> grantor = grantorRepository.findById(id);
        return grantor.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Grantor save(Grantor grantor) {
        return grantorRepository.save(grantor);
    }

    public void deleteById(Long id) {
        try {
            if (!grantorRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            grantorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(Grantor grantor) {
        try {
            if (!grantorRepository.existsById(grantor.getId()))
                throw new ResourceNotFoundException(grantor.getId());

            grantorRepository.delete(grantor);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Grantor update(Long id, Grantor grantor) {
        try {
            Grantor grantorEntityReference = grantorRepository.getReferenceById(id);

            grantorEntityReference.setName(grantor.getName());

            return grantorRepository.save(grantorEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
