package br.ufes.sead.erp.shared.email;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.ufes.sead.erp.financial.fest.entities.ContractEventReminder;
import br.ufes.sead.erp.financial.fest.services.ContractEventReminderService;

@Component
public class ScheduledTasks {

    @Autowired
    private ContractEventReminderService contractEventReminderService;

    @Autowired
    private EmailService emailService;

    DateTimeFormatter logFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // @Scheduled(cron = "* 7 3/12 * * *")
    @Scheduled(cron = "0/30 * * * * *")
    public void sendContractsEventsEmails() {

        String recipients = "jake@gmail.com";

        System.out.println(LocalDateTime.now().format(logFormat) + " | Checking for overdue contracts events reminders...");

        List<ContractEventReminder> overdueReminders = contractEventReminderService.findOverdue();

        for (ContractEventReminder reminder : overdueReminders) {
            System.out.println("Sending email for contract " + reminder.getContract().getId() + " event " + reminder.getEventType());

            Email email = new Email(
                recipients,

                "Alerta de evento: " + reminder.eventTypeLabel() + " do contrato de "
                    + reminder.getContract().getEmployee().getGivenName() + " "
                    + reminder.getContract().getEmployee().getSurname(),

                "Alerta para o evento do <a href=\"http://localhost:4200/financeiro/termos/" + reminder.getContract().getId() + "\" target=\"_blank\">contrato</a>.\n\n"
                    + "Colaborador: " + reminder.getContract().getEmployee().getGivenName() + " " + reminder.getContract().getEmployee().getSurname() + "\n"
                    + "Evento: " + reminder.eventTypeLabel() + "\n"
                    + "Data do evento: " + reminder.getEventReminderDate().format(simpleDate) + "\n\n"
                    + "Observação: " + ((reminder.getNote() != null) ? reminder.getNote().getContent() : "-"),

                null
            );

            emailService.sendEmail(email);
            reminder.setSent(true);
            contractEventReminderService.save(reminder);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (overdueReminders.isEmpty()) {
            System.out.println(LocalDateTime.now().format(logFormat) + " | No overdue contracts events reminders found.");
        }

    }

}
