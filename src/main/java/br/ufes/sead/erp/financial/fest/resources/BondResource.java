package br.ufes.sead.erp.financial.fest.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufes.sead.erp.financial.fest.entities.Bond;
import br.ufes.sead.erp.financial.fest.services.BondService;

@RestController
@RequestMapping(value = "/api/v1/financial/fest/bonds")
public class BondResource {

    private final BondService service;

    public BondResource(BondService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Bond>> findAll() {
        List<Bond> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Bond> findById(@PathVariable Long id) {
        Bond obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Bond> insert(@RequestBody Bond obj) {
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Bond> update(@PathVariable Long id, @RequestBody Bond obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
