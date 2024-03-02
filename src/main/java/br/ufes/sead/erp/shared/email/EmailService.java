package br.ufes.sead.erp.shared.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.shared.FileReadingService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FileReadingService fileReadingService;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendEmail(Email email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            message.setFrom("ERP Sead<" + sender + ">");
            message.setRecipients(MimeMessage.RecipientType.TO, email.getRecipients());
            message.setSubject(email.getSubject());

            String htmlContent = fileReadingService.readFileAsString("templates/email-template.html");

            htmlContent = htmlContent.replace("{{message}}", email.getBody());
            htmlContent = htmlContent.replace("{{year}}", String.valueOf(java.time.LocalDate.now().getYear()));

            message.setContent(htmlContent, "text/html; charset=utf-8");

            mailSender.send(message);
            return "Email sent successfully";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }

    public String sendEmailWithAttachment(Email email) throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "utf-8");

            helper.setFrom("ERP Sead<" + sender + ">");
            String[] recipients = email.getRecipients().split(",");
            helper.setTo(recipients);
            helper.setSubject(email.getSubject());

            String htmlContent = fileReadingService.readFileAsString("src/main/resources/templates/email-template.html");

            htmlContent = htmlContent.replace("{{message}}", email.getBody());
            htmlContent = htmlContent.replace("{{year}}", String.valueOf(java.time.LocalDate.now().getYear()));

            helper.setText(htmlContent, true);

            helper.addAttachment(email.getAttachment().getName(), email.getAttachment());

            mailSender.send(message);
            return "Email sent successfully";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
