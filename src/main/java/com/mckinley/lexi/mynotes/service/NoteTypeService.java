package com.mckinley.lexi.mynotes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mckinley.lexi.mynotes.model.EntityNoteType;
import com.mckinley.lexi.mynotes.repository.NoteTypeRepository;

@Service
public class NoteTypeService {

    @Autowired
    private NoteTypeRepository noteTypeRepository;
    
    public List<EntityNoteType> getNoteTypeData(){
        List<EntityNoteType> noteTypeList = new ArrayList<EntityNoteType>();
        noteTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "name")).forEach(noteTypeList::add);
        return noteTypeList;     
    }

    public EntityNoteType getNoteType(int id){return noteTypeRepository.findById(id).orElseThrow(() -> new EntityNotFound(id,"notetype"));}

    public void addNoteType(EntityNoteType noteType){noteTypeRepository.save(noteType);}

    public void updateNoteType(int id, EntityNoteType noteType){noteTypeRepository.save(noteType);}

    public void deleteNoteType(int id){noteTypeRepository.deleteById(id);}


}
