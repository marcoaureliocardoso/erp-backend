package br.ufes.sead.erp.financial.fest.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufes.sead.erp.financial.fest.entities.BondEventReminder;

public interface BondEventReminderRepository extends JpaRepository<BondEventReminder, Long> {

    @Query("SELECT c FROM BondEventReminder c WHERE c.eventReminderDate <= :date AND c.sent = false")
    public List<BondEventReminder> findOverdue(@Param("date") LocalDate date);

}
