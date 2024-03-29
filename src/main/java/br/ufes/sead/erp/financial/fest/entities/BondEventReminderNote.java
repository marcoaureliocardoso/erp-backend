package br.ufes.sead.erp.financial.fest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bond_event_notes")
public class BondEventReminderNote {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private BondEventReminder eventReminder;

    public BondEventReminderNote() {
    }

    public BondEventReminderNote(String content, BondEventReminder eventReminder) {
        this.content = content;
        this.eventReminder = eventReminder;
    }

    public BondEventReminderNote(Long id, String content, BondEventReminder eventReminder) {
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

    public BondEventReminder getEventReminder() {
        return eventReminder;
    }

    public void setEventReminder(BondEventReminder eventReminder) {
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
        BondEventReminderNote other = (BondEventReminderNote) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BondEventReminderNote [id=" + id + ", content=" + content + "]";
    }

}
