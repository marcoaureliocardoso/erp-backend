package br.ufes.sead.erp.financial.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufes.sead.erp.financial.entities.ContractEventReminder;

public interface ContractEventReminderRepository extends JpaRepository<ContractEventReminder, Long> {

    @Query("SELECT c FROM ContractEventReminder c WHERE c.eventReminderDate <= :date AND c.sent = false")
    public List<ContractEventReminder> findOverdue(@Param("date") LocalDate date);

}
