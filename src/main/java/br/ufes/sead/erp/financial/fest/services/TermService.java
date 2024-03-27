package br.ufes.sead.erp.financial.fest.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.exceptions.DatabaseException;
import br.ufes.sead.erp.exceptions.ResourceNotFoundException;
import br.ufes.sead.erp.financial.fest.entities.Term;
import br.ufes.sead.erp.financial.fest.repositories.TermRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TermService {

    private final TermRepository termRepository;

    public TermService(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public List<Term> findAll() {
        return termRepository.findAll();
    }

    public Term findById(Long id) {
        return termRepository.findById(id).orElse(null);
    }

    public Term save(Term term) {
        return termRepository.save(term);
    }

    public void deleteById(Long id) {
        try {
            if (!termRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            termRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Term update(Long id, Term term) {
        try {
            Term termEntityReference = termRepository.getReferenceById(id);

            termEntityReference.setType(term.getType());
            termEntityReference.setPath(term.getPath());

            return termRepository.save(termEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

}
