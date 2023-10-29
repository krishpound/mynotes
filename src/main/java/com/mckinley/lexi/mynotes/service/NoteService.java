package com.mckinley.lexi.mynotes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mckinley.lexi.mynotes.model.EntityNote;
import com.mckinley.lexi.mynotes.repository.NoteRepository;

@Service
public class NoteService {

    @Autowired   
    private ClientService clientService;

    @Autowired
    private NoteRepository noteRepository;
    
    public List<EntityNote> getNoteData(){
        List<EntityNote> noteList = new ArrayList<EntityNote>();
        noteRepository.findAll().forEach(noteList::add);
        return noteList;     
    }

    public List<EntityNote> getNoteDataByClient(int id){
        List<EntityNote> noteList = new ArrayList<EntityNote>();
        noteRepository.findByClient(clientService.getClient(id)).forEach(noteList::add);
        return noteList;     
    }


    public EntityNote getNote(int id){return noteRepository.findById(id).orElseThrow(() -> new EntityNotFound(id,"note"));}

    public void addNote(EntityNote note){noteRepository.save(note);}

    public void updateNote(int id, EntityNote client){noteRepository.save(client);}

    public void deleteNote(int id){noteRepository.deleteById(id);}

}
