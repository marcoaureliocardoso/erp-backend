package br.ufes.sead.erp.financial.fest.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.ufes.sead.erp.financial.fest.entities.BondEventReminder;
import br.ufes.sead.erp.financial.fest.services.BondEventReminderService;

@RestController
@RequestMapping(value = "/api/v1/financial/fest/bond-event-reminders")
public class BondEventReminderResource {

    @Autowired
    private BondEventReminderService service;

    @GetMapping
    public ResponseEntity<List<BondEventReminder>> findAll() {
        List<BondEventReminder> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BondEventReminder> findById(@PathVariable Long id) {
        BondEventReminder obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<BondEventReminder> insert(@RequestBody BondEventReminder obj) {
        obj = service.save(obj);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
                .toUriString());
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BondEventReminder> update(@PathVariable Long id, @RequestBody BondEventReminder obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}/note")
    public ResponseEntity<BondEventReminder> updateNote(@PathVariable Long id, @RequestBody BondEventReminder obj) {
        obj = service.updateNote(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
