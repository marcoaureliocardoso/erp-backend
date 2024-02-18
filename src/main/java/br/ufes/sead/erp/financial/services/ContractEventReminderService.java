package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.ContractEventReminder;
import br.ufes.sead.erp.financial.repositories.ContractEventReminderRepository;

@Service
public class ContractEventReminderService {

    @Autowired
    private ContractEventReminderRepository contractEventRepository;

    public List<ContractEventReminder> findAll() {
        return contractEventRepository.findAll();
    }

    public ContractEventReminder findById(Long id) {
        return contractEventRepository.findById(id).orElse(null);
    }

    public ContractEventReminder save(ContractEventReminder contractEventReminder) {
        return contractEventRepository.save(contractEventReminder);
    }

    public void deleteById(Long id) {
        contractEventRepository.deleteById(id);
    }

    public void delete(ContractEventReminder contractEventReminder) {
        contractEventRepository.delete(contractEventReminder);
    }
}
