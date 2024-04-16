package br.ufes.sead.erp.shared;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.ufes.sead.erp.financial.fest.entities.BondEventReminder;
import br.ufes.sead.erp.financial.fest.services.BondEventReminderService;
import br.ufes.sead.erp.shared.email.Email;
import br.ufes.sead.erp.shared.email.EmailService;

@Component
public class ScheduledTasks {

    private final BondEventReminderService bondEventReminderService;
    private final EmailService emailService;

    private final String festRecipients;

    private final DateTimeFormatter logFormat;
    private final DateTimeFormatter simpleDate;

    public ScheduledTasks(BondEventReminderService bondEventReminderService, EmailService emailService,
    @Value("${erp.mail.fest.recipients}") String festRecipients) {
        this.bondEventReminderService = bondEventReminderService;
        this.emailService = emailService;
        this.festRecipients = festRecipients;
        this.logFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.simpleDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    // @Scheduled(cron = "* 7 3/12 * * *")
    @Scheduled(cron = "0/30 * * * * *")
    public void sendBondsEventsEmails() {

        System.out.println(LocalDateTime.now().format(logFormat) + " | Checking for overdue Bonds events reminders...");

        List<BondEventReminder> overdueReminders = bondEventReminderService.findOverdue();

        for (BondEventReminder reminder : overdueReminders) {
            System.out.println("Sending email for Bond " + reminder.getBond().getId() + " event " + reminder.getEventType());

            Email email = new Email(
                this.festRecipients + "," + reminder.getBond().getEmployee().getEmail(),

                "Alerta de evento: " + reminder.eventTypeLabel() + " do vínculo de "
                    + reminder.getBond().getEmployee().getGivenName() + " "
                    + reminder.getBond().getEmployee().getSurname(),

                "Alerta para o evento do <a href=\"http://localhost:4200/financeiro/fest/vinculos/" + reminder.getBond().getId() + "\" target=\"_blank\">vínculo</a>.\n\n"
                    + "Colaborador: " + reminder.getBond().getEmployee().getGivenName() + " " + reminder.getBond().getEmployee().getSurname() + "\n"
                    + "Evento: " + reminder.eventTypeLabel() + "\n"
                    + "Data do evento: " + reminder.getEventReminderDate().format(simpleDate) + "\n\n"
                    + "Observação: " + ((reminder.getNote() != null) ? reminder.getNote().getContent() : "-"),

                null
            );

            emailService.sendEmail(email);
            reminder.setSent(true);
            bondEventReminderService.save(reminder);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (overdueReminders.isEmpty()) {
            System.out.println(LocalDateTime.now().format(logFormat) + " | No overdue Bonds events reminders found.");
        }

    }

}
