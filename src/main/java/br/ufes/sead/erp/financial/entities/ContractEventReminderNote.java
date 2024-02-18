package br.ufes.sead.erp.financial.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract_event_notes")
public class ContractEventReminderNote {
    @Id
    private Long id;
    @Column(nullable = false)
    private String note;

    public ContractEventReminderNote() {
    }

    public ContractEventReminderNote(Long id, String note) {
        this.id = id;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
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
        ContractEventReminderNote other = (ContractEventReminderNote) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ContractEventReminderNote [id=" + id + ", note=" + note + "]";
    }

}
