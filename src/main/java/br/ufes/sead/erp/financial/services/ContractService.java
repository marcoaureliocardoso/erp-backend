package br.ufes.sead.erp.financial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Contract;
import br.ufes.sead.erp.financial.repositories.ContractRepository;
import br.ufes.sead.erp.financial.services.exceptions.DatabaseException;
import br.ufes.sead.erp.financial.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findById(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        return contract.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteById(Long id) {
        try {
            if (!contractRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            contractRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(Contract contract) {
        try {
            if (!contractRepository.existsById(contract.getId()))
                throw new ResourceNotFoundException(contract.getId());

            contractRepository.delete(contract);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Contract update(Long id, Contract contract) {
        try {
            Contract contractEntityReference = contractRepository.getReferenceById(id);

            contractEntityReference.setStartDate(contract.getStartDate());
            contractEntityReference.setEndDate(contract.getEndDate());
            contractEntityReference.setProject(contract.getProject());
            contractEntityReference.setCourse(contract.getCourse());
            contractEntityReference.setEmployee(contract.getEmployee());

            return contractRepository.save(contractEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
