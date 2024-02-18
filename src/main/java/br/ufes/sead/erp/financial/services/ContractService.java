package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Contract;
import br.ufes.sead.erp.financial.repositories.ContractRepository;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

}
