package br.ufes.sead.erp.financial.entities;

import br.ufes.sead.erp.financial.entities.enums.EventType;

public class ContractEvent {
    private long id;
    private Contract contract;
    private EventType eventType;
    private ContractEventNote note;

    public ContractEvent() {
    }

    public ContractEvent(long id, Contract contract, EventType eventType, ContractEventNote note) {
        this.id = id;
        this.contract = contract;
        this.eventType = eventType;
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
        return "ContractEvent [id=" + id + ", contract=" + contract + ", eventType=" + eventType + ", note=" + note
                + "]";
    }

}
