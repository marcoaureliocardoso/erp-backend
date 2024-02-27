package br.ufes.sead.erp.financial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Contract;
import br.ufes.sead.erp.financial.entities.ContractEventReminder;
import br.ufes.sead.erp.financial.entities.enums.EventType;
import br.ufes.sead.erp.financial.repositories.ContractRepository;
import br.ufes.sead.erp.financial.services.exceptions.DatabaseException;
import br.ufes.sead.erp.financial.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

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

    @Transactional(value = TxType.REQUIRES_NEW)
    public Contract save(Contract contract) {

        if (contract.getStartDate().isAfter(contract.getEndDate()))
            throw new IllegalArgumentException("The start date must be before the end date");

        ContractEventReminder recess1Reminder = new ContractEventReminder(contract, EventType.RECESS1, contract.getFirstRecessInformLimitDate().minusDays(16));
        ContractEventReminder recess2Reminder = new ContractEventReminder(contract, EventType.RECESS2, contract.getSecondRecessInformLimitDate().minusDays(16));

        ContractEventReminder report1DeadlineReminder = new ContractEventReminder(contract, EventType.REPORT1_DELIVERY, contract.getFirstReportLimitDate().minusDays(15));
        ContractEventReminder report2DeadlineReminder = new ContractEventReminder(contract, EventType.REPORT2_DELIVERY, contract.getSecondReportLimitDate().minusDays(15));

        ContractEventReminder contractEndReminder = new ContractEventReminder(contract, EventType.CONTRACT_END, contract.getEndDate().minusMonths(1));

        contract.addEventReminder(recess1Reminder);
        contract.addEventReminder(recess2Reminder);
        contract.addEventReminder(report1DeadlineReminder);
        contract.addEventReminder(report2DeadlineReminder);
        contract.addEventReminder(contractEndReminder);

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

    @Transactional(value = TxType.REQUIRES_NEW)
    public Contract update(Long id, Contract contract) {
        try {
            Contract contractEntityReference = contractRepository.getReferenceById(id);

            contractEntityReference.setStartDate(contract.getStartDate());
            contractEntityReference.setEndDate(contract.getEndDate());
            contractEntityReference.setProject(contract.getProject());
            contractEntityReference.setCourse(contract.getCourse());
            contractEntityReference.setEmployee(contract.getEmployee());

            List<ContractEventReminder> eventReminders = contractEntityReference.getEventReminders();

            for (ContractEventReminder eventReminder : eventReminders) {
                switch (eventReminder.getEventType()) {
                    case RECESS1:
                        eventReminder.setEventReminderDate(contractEntityReference.getFirstRecessInformLimitDate().minusDays(16));
                        break;
                    case RECESS2:
                        eventReminder.setEventReminderDate(contractEntityReference.getSecondRecessInformLimitDate().minusDays(16));
                        break;
                    case REPORT1_DELIVERY:
                        eventReminder.setEventReminderDate(contractEntityReference.getFirstReportLimitDate().minusDays(15));
                        break;
                    case REPORT2_DELIVERY:
                        eventReminder.setEventReminderDate(contractEntityReference.getSecondReportLimitDate().minusDays(15));
                        break;
                    case CONTRACT_END:
                        eventReminder.setEventReminderDate(contractEntityReference.getEndDate().minusMonths(1));
                        break;
                    default:
                        break;
                }
            }

            return contractRepository.save(contractEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
