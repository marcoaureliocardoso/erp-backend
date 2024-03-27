package br.ufes.sead.erp.financial.fest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.exceptions.DatabaseException;
import br.ufes.sead.erp.exceptions.ResourceNotFoundException;
import br.ufes.sead.erp.financial.fest.entities.Bond;
import br.ufes.sead.erp.financial.fest.entities.BondEventReminder;
import br.ufes.sead.erp.financial.fest.entities.enums.EventType;
import br.ufes.sead.erp.financial.fest.repositories.BondRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class BondService {

    private final BondRepository bondRepository;

    // @Autowired
    // private EmailService emailService;

    // private final String recipients = "alan@gmail.com, charlie@gmail.com";

    public BondService(BondRepository bondRepository) {
        this.bondRepository = bondRepository;
    }

    public List<Bond> findAll() {
        return bondRepository.findAll();
    }

    public Bond findById(Long id) {
        Optional<Bond> bond = bondRepository.findById(id);
        return bond.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public Bond save(Bond bond) {

        if (bond.getStartDate().isAfter(bond.getEndDate()))
            throw new IllegalArgumentException("The start date must be before the end date");

        BondEventReminder recess1Reminder = new BondEventReminder(bond, EventType.RECESS1, bond.getFirstRecessInformLimitDate().minusDays(16));
        BondEventReminder recess2Reminder = new BondEventReminder(bond, EventType.RECESS2, bond.getSecondRecessInformLimitDate().minusDays(16));

        BondEventReminder report1DeadlineReminder = new BondEventReminder(bond, EventType.REPORT1_DELIVERY, bond.getFirstReportLimitDate().minusDays(15));
        BondEventReminder report2DeadlineReminder = new BondEventReminder(bond, EventType.REPORT2_DELIVERY, bond.getSecondReportLimitDate().minusDays(15));

        BondEventReminder bondEndReminder = new BondEventReminder(bond, EventType.BOND_END, bond.getEndDate().minusMonths(1));

        bond.addEventReminder(recess1Reminder);
        bond.addEventReminder(recess2Reminder);
        bond.addEventReminder(report1DeadlineReminder);
        bond.addEventReminder(report2DeadlineReminder);
        bond.addEventReminder(bondEndReminder);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // String subject = "[**TESTE**] Novo Termo Cadastrado [" + bond.getEmployee().getGivenName() + " " + bond.getEmployee().getSurname() + "]";

        // String message = "Um novo vínculo foi cadastrado" + "\n\n" +
        //         "Nome: " + bond.getEmployee().getGivenName() + " " + bond.getEmployee().getSurname() + "\n" +
        //         "Projeto: " + bond.getProject().getName() + "\n" +
        //         "Curso: " + bond.getCourse().getName() + "\n" +
        //         "Data de início: " + bond.getStartDate().format(formatter) + "\n" +
        //         "Data de término: " + bond.getEndDate().format(formatter);

        // emailService.sendEmail(new Email(recipients, subject, message, null));

        // try {
        //     File file = new File("src/main/resources/test.txt");
        //     if (!file.exists()) {
        //         throw new RuntimeException("File not found");
        //     }

        //     emailService.sendEmailWithAttachment(new Email(recipients, subject, message, file));
        // } catch (Exception e) {
        //     throw new RuntimeException("Error sending email: " + e.getMessage());
        // }

        return bondRepository.save(bond);
    }

    public void deleteById(Long id) {
        try {
            if (!bondRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            bondRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(Bond bond) {
        try {
            if (!bondRepository.existsById(bond.getId()))
                throw new ResourceNotFoundException(bond.getId());

            bondRepository.delete(bond);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public Bond update(Long id, Bond bond) {
        try {
            Bond bondEntityReference = bondRepository.getReferenceById(id);

            bondEntityReference.setStartDate(bond.getStartDate());
            bondEntityReference.setEndDate(bond.getEndDate());
            bondEntityReference.setProject(bond.getProject());
            bondEntityReference.setCourse(bond.getCourse());
            bondEntityReference.setEmployee(bond.getEmployee());

            List<BondEventReminder> eventReminders = bondEntityReference.getEventReminders();

            for (BondEventReminder eventReminder : eventReminders) {
                switch (eventReminder.getEventType()) {
                    case RECESS1:
                        eventReminder.setEventReminderDate(bondEntityReference.getFirstRecessInformLimitDate().minusDays(16));
                        break;
                    case RECESS2:
                        eventReminder.setEventReminderDate(bondEntityReference.getSecondRecessInformLimitDate().minusDays(16));
                        break;
                    case REPORT1_DELIVERY:
                        eventReminder.setEventReminderDate(bondEntityReference.getFirstReportLimitDate().minusDays(15));
                        break;
                    case REPORT2_DELIVERY:
                        eventReminder.setEventReminderDate(bondEntityReference.getSecondReportLimitDate().minusDays(15));
                        break;
                    case BOND_END:
                        eventReminder.setEventReminderDate(bondEntityReference.getEndDate().minusMonths(1));
                        break;
                    default:
                        break;
                }
            }

            return bondRepository.save(bondEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
