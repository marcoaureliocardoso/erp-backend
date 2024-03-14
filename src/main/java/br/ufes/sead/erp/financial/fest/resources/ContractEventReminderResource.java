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

import br.ufes.sead.erp.financial.fest.entities.ContractEventReminder;
import br.ufes.sead.erp.financial.fest.services.ContractEventReminderService;

@RestController
@RequestMapping(value = "/api/v1/financial/fest/contract-event-reminders")
public class ContractEventReminderResource {

    @Autowired
    private ContractEventReminderService service;

    @GetMapping
    public ResponseEntity<List<ContractEventReminder>> findAll() {
        List<ContractEventReminder> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContractEventReminder> findById(@PathVariable Long id) {
        ContractEventReminder obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ContractEventReminder> insert(@RequestBody ContractEventReminder obj) {
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
    public ResponseEntity<ContractEventReminder> update(@PathVariable Long id, @RequestBody ContractEventReminder obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}/note")
    public ResponseEntity<ContractEventReminder> updateNote(@PathVariable Long id, @RequestBody ContractEventReminder obj) {
        obj = service.updateNote(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
