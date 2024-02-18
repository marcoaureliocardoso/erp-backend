package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Grantor;
import br.ufes.sead.erp.financial.repositories.GrantorRepository;

@Service
public class GrantorService {

    @Autowired
    private GrantorRepository grantorRepository;

    public List<Grantor> findAll() {
        return grantorRepository.findAll();
    }

    public Grantor findById(Long id) {
        return grantorRepository.findById(id).orElse(null);
    }

    public Grantor save(Grantor grantor) {
        return grantorRepository.save(grantor);
    }

    public void deleteById(Long id) {
        grantorRepository.deleteById(id);
    }

    public void delete(Grantor grantor) {
        grantorRepository.delete(grantor);
    }

}
