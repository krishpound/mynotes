package com.mckinley.lexi.mynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mckinley.lexi.mynotes.model.EntityClient;

public interface ClientRepository extends JpaRepository<EntityClient, Integer> {}


