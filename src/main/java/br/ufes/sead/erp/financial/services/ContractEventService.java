package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.ContractEvent;
import br.ufes.sead.erp.financial.repositories.ContractEventRepository;

@Service
public class ContractEventService {

    @Autowired
    private ContractEventRepository contractEventRepository;

    public List<ContractEvent> findAll() {
        return contractEventRepository.findAll();
    }

    public ContractEvent findById(Long id) {
        return contractEventRepository.findById(id).orElse(null);
    }

    public ContractEvent save(ContractEvent contractEvent) {
        return contractEventRepository.save(contractEvent);
    }

    public void deleteById(Long id) {
        contractEventRepository.deleteById(id);
    }

    public void delete(ContractEvent contractEvent) {
        contractEventRepository.delete(contractEvent);
    }
}
