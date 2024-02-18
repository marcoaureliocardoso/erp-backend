package br.ufes.sead.erp.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.entities.ContractEventReminder;

public interface ContractEventReminderRepository extends JpaRepository<ContractEventReminder, Long> {

}
