package br.ufes.sead.erp.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.entities.ContractEvent;

public interface ContractEventRepository extends JpaRepository<ContractEvent, Long> {

}
