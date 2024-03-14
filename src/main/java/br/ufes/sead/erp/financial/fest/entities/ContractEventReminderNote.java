package br.ufes.sead.erp.financial.fest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract_event_notes")
public class ContractEventReminderNote {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private ContractEventReminder eventReminder;

    public ContractEventReminderNote() {
    }

    public ContractEventReminderNote(String content, ContractEventReminder eventReminder) {
        this.content = content;
        this.eventReminder = eventReminder;
    }

    public ContractEventReminderNote(Long id, String content, ContractEventReminder eventReminder) {
        this.id = id;
        this.content = content;
        this.eventReminder = eventReminder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContractEventReminder getEventReminder() {
        return eventReminder;
    }

    public void setEventReminder(ContractEventReminder eventReminder) {
        this.eventReminder = eventReminder;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ContractEventReminderNote other = (ContractEventReminderNote) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ContractEventReminderNote [id=" + id + ", content=" + content + "]";
    }

}
