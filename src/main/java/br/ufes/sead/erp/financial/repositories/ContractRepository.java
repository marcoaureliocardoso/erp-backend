package br.ufes.sead.erp.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
