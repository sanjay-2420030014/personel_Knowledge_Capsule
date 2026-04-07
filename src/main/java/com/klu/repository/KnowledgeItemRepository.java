package com.klu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.KnowledgeItem;

import java.util.List;

public interface KnowledgeItemRepository extends JpaRepository<KnowledgeItem, Long> {

    List<KnowledgeItem> findByCategory(String category);

    List<KnowledgeItem> findByLocked(boolean locked);
}

