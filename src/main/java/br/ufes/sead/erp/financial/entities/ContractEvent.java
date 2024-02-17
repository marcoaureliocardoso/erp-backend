package br.ufes.sead.erp.financial.entities;

import java.io.Serializable;
import java.time.LocalDate;

import br.ufes.sead.erp.financial.entities.enums.EventType;
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
@Table(name = "contract_events")
public class ContractEvent implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Contract contract;
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private LocalDate eventDate;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ContractEventNote note;

    public ContractEvent() {
    }

    public ContractEvent(Long id, Contract contract, EventType eventType, LocalDate eventDate, ContractEventNote note) {
        this.id = id;
        this.contract = contract;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.note = note;
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ContractEventNote getNote() {
        return note;
    }

    public void setNote(ContractEventNote note) {
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
        ContractEvent other = (ContractEvent) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ContractEvent [id=" + id + ", contract=" + contract + ", eventType=" + eventType + ", eventDate="
                + eventDate + ", note=" + note + "]";
    }

}
