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
@Table(name = "contract_event_reminders")
public class ContractEventReminder {
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
    private ContractEventReminderNote note;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties({ "eventReminders", "project", "course" })
    private Contract contract;

    public ContractEventReminder() {
    }

    public ContractEventReminder(Contract contract, EventType eventType, LocalDate eventReminderDate, ContractEventReminderNote note) {
        this.contract = contract;
        this.eventType = eventType;
        this.eventReminderDate = eventReminderDate;
        this.sent = false;
        this.note = note;
    }

    public ContractEventReminder(Contract contract, EventType eventType, LocalDate eventReminderDate) {
        this.contract = contract;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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

    public ContractEventReminderNote getNote() {
        return note;
    }

    public void setNote(ContractEventReminderNote note) {
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
        ContractEventReminder other = (ContractEventReminder) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ContractEventReminder [id=" + id + ", eventType=" + eventType + ", eventReminderDate="
                + eventReminderDate + ", sent=" + sent + ", note=" + note
                + ", contract=" + contract + "]";
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
            case CONTRACT_END:
                return "Fim do Contrato";
            default:
                return "Evento Desconhecido";
        }
    }

}
