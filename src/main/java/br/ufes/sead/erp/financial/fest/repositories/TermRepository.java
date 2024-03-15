package br.ufes.sead.erp.financial.fest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.fest.entities.Term;

public interface TermRepository extends JpaRepository<Term, Long>{
    
}
