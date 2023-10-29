package com.mckinley.lexi.mynotes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mckinley.lexi.mynotes.model.EntityNoteType;
import com.mckinley.lexi.mynotes.service.NoteTypeService;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class NoteTypeController {

    @Autowired   
    private NoteTypeService noteTypeService;

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value = "/notetypes")
    public List <EntityNoteType> getNoteTypes(){  
        return noteTypeService.getNoteTypeData();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value="/notetypes/{id}")
    public EntityNoteType getNoteType(@PathVariable Integer id){
        return noteTypeService.getNoteType(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.POST, value="/notetypes")
    public ResponseEntity<String> addNoteType(@RequestBody String noteTypeName){
        try{
            EntityNoteType noteType = new EntityNoteType();
            Instant rightNow = Instant.now();
            noteType.name(noteTypeName.replaceAll("\"", "").replaceAll("^\\s+", "").replaceAll("\\s+$", ""));
            noteType.created(rightNow);
            noteType.modified(rightNow);
            noteTypeService.addNoteType(noteType);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("notetype added",HttpStatus.CREATED);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.PUT, value="/notetypes/{id}")
    public ResponseEntity<String> updateNoteType(@RequestBody String noteTypeName, @PathVariable Integer id){
        try{
            EntityNoteType noteType = noteTypeService.getNoteType(id);
            noteType.name(noteTypeName);
            noteType.modified(Instant.now());
            noteTypeService.updateNoteType(id, noteType);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("notetype "+id+" updated",HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.DELETE, value="/notetypes/{id}")
    public ResponseEntity<String> deleteNoteType(@PathVariable Integer id){
        try{
            noteTypeService.deleteNoteType(id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("notetype "+id+" deleted",HttpStatus.OK);
    }

}