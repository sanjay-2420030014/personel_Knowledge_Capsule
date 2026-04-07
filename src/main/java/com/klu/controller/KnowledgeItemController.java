package com.klu.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.KnowledgeItem;
import com.klu.service.KnowledgeItemService;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge")
@CrossOrigin(origins = "*")
public class KnowledgeItemController {

    private final KnowledgeItemService service;

    public KnowledgeItemController(KnowledgeItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<KnowledgeItem> create(@RequestBody KnowledgeItem item) {
        return ResponseEntity.ok(service.addItem(item));
    }

    @GetMapping
    public ResponseEntity<List<KnowledgeItem>> getAll() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KnowledgeItem> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getItemById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}

