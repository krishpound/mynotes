package com.mckinley.lexi.mynotes.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.CrudRepository;
import com.mckinley.lexi.mynotes.model.EntityDefaults;

public interface DefaultsRepository extends CrudRepository<EntityDefaults, Integer> {

    Iterable<Order> findAll(Sort by);
    //@Query("SELECT s.instance,sa.alert FROM server s JOIN s.serverid sa ")
}
