package br.ufes.sead.erp.shared.email;

import java.io.File;

public class Email {
    private String recipients;
    private String subject;
    private String body;
    private File attachment;

    public Email() {
    }

    public Email(String recipients, String subject, String body, File attachment) {
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((recipients == null) ? 0 : recipients.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Email other = (Email) obj;
        if (recipients == null) {
            if (other.recipients != null)
                return false;
        } else if (!recipients.equals(other.recipients))
            return false;
        if (subject == null) {
            if (other.subject != null)
                return false;
        } else if (!subject.equals(other.subject))
            return false;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (attachment == null) {
            if (other.attachment != null)
                return false;
        } else if (!attachment.equals(other.attachment))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Email [recipients=" + recipients + ", subject=" + subject + ", body=" + body + ", attachment="
                + attachment + "]";
    }

}
