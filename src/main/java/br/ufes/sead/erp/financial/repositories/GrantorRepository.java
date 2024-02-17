package br.ufes.sead.erp.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.entities.Grantor;

public interface GrantorRepository extends JpaRepository<Grantor, Long> {

}
