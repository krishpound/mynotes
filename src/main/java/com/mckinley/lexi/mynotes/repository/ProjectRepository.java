package com.mckinley.lexi.mynotes.repository;

import com.mckinley.lexi.mynotes.model.EntityProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<EntityProject, Integer> {
    //@Query("SELECT s.instance,sa.alert FROM server s JOIN s.serverid sa ")
}