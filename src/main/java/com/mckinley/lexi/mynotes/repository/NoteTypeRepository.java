package com.mckinley.lexi.mynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mckinley.lexi.mynotes.model.EntityNoteType;

public interface NoteTypeRepository extends JpaRepository<EntityNoteType, Integer> {
    //@Query("SELECT s.instance,sa.alert FROM server s JOIN s.serverid sa ")
}