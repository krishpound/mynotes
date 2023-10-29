package com.mckinley.lexi.mynotes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.mckinley.lexi.mynotes.model.EntityClient;
import com.mckinley.lexi.mynotes.model.EntityNote;

public interface NoteRepository extends CrudRepository<EntityNote, Integer> {
    //@Query("SELECT s.instance,sa.alert FROM server s JOIN s.serverid sa ")

    List<EntityNote> findByClient(EntityClient client);


}
