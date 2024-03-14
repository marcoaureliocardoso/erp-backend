package br.ufes.sead.erp.financial.fest.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.ufes.sead.erp.financial.fest.entities.enums.EventType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "bond_event_reminders")
public class BondEventReminder {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDate eventReminderDate;

    private Boolean sent;

    @OneToOne(mappedBy = "eventReminder", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BondEventReminderNote note;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties({ "eventReminders", "project", "course" })
    private Bond bond;

    public BondEventReminder() {
    }

    public BondEventReminder(Bond bond, EventType eventType, LocalDate eventReminderDate, BondEventReminderNote note) {
        this.bond = bond;
        this.eventType = eventType;
        this.eventReminderDate = eventReminderDate;
        this.sent = false;
        this.note = note;
    }

    public BondEventReminder(Bond bond, EventType eventType, LocalDate eventReminderDate) {
        this.bond = bond;
        this.eventType = eventType;
        this.eventReminderDate = eventReminderDate;
        this.sent = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bond getBond() {
        return bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDate getEventReminderDate() {
        return eventReminderDate;
    }

    public void setEventReminderDate(LocalDate eventReminderDate) {
        this.eventReminderDate = eventReminderDate;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public BondEventReminderNote getNote() {
        return note;
    }

    public void setNote(BondEventReminderNote note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        BondEventReminder other = (BondEventReminder) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BondEventReminder [id=" + id + ", eventType=" + eventType + ", eventReminderDate="
                + eventReminderDate + ", sent=" + sent + ", note=" + note
                + ", bond=" + bond + "]";
    }

    public String eventTypeLabel() {
        switch (eventType) {
            case RECESS1:
                return "1° Recesso";
            case RECESS2:
                return "2° Recesso";
            case REPORT1_DELIVERY:
                return "1ª Entrega de Relatório";
            case REPORT2_DELIVERY:
                return "2ª Entrega de Relatório";
            case BOND_END:
                return "Fim do Vínculo";
            default:
                return "Evento Desconhecido";
        }
    }

}
