package com.mckinley.lexi.mynotes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mckinley.lexi.mynotes.model.EntityDefaults;
import com.mckinley.lexi.mynotes.repository.DefaultsRepository;

@Service
public class DefaultsService {

    @Autowired
    private DefaultsRepository defaultsRepository;
    
    public List<EntityDefaults> getDefaultData(){
        List<EntityDefaults> defaultList = new ArrayList<EntityDefaults>();
        defaultsRepository.findAll().forEach(defaultList::add);
        return defaultList;     
    }

    public EntityDefaults getDefault(int id){return defaultsRepository.findById(id).orElseThrow(() -> new EntityNotFound(id,"defaults"));}

    public void addDefault(EntityDefaults defaults){defaultsRepository.save(defaults);}

    public void updateDefault(int id, EntityDefaults defaults){defaultsRepository.save(defaults);}

    public void deleteDefault(int id){defaultsRepository.deleteById(id);}

}
