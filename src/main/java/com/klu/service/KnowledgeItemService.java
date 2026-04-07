package com.klu.service;


import org.springframework.stereotype.Service;

import com.klu.entity.KnowledgeItem;
import com.klu.repository.KnowledgeItemRepository;

import java.util.List;

@Service
public class KnowledgeItemService {

    private final KnowledgeItemRepository repository;

    public KnowledgeItemService(KnowledgeItemRepository repository) {
        this.repository = repository;
    }

    public KnowledgeItem addItem(KnowledgeItem item) {
        return repository.save(item);
    }

    public List<KnowledgeItem> getAllItems() {
        return repository.findAll();
    }

    public KnowledgeItem getItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public List<KnowledgeItem> getByCategory(String category) {
        return repository.findByCategory(category);
    }
}
