package com.mckinley.lexi.mynotes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mckinley.lexi.mynotes.model.EntityNote;
import com.mckinley.lexi.mynotes.model.NoteDTO;
import com.mckinley.lexi.mynotes.service.ClientService;
import com.mckinley.lexi.mynotes.service.ProjectService;
import com.mckinley.lexi.mynotes.service.NoteTypeService;
import com.mckinley.lexi.mynotes.service.NoteService;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class NoteController {

    @Autowired   
    private NoteService noteService;

    @Autowired   
    private ProjectService projectService;

    @Autowired   
    private NoteTypeService noteTypeService;

    @Autowired   
    private ClientService clientService;

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value = "/notes")
    public List <EntityNote> getNotes(){  
        return noteService.getNoteData();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value="/notes/{id}")
    public List<EntityNote> getNote(@PathVariable Integer id){
        return noteService.getNoteDataByClient(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.POST, value="/notes")
    public ResponseEntity<String> addNote(@RequestBody NoteDTO noteDTO){
        try{
            EntityNote note = new EntityNote();
            Instant rightNow = Instant.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		    ZonedDateTime zonedDateTime = ZonedDateTime.parse(noteDTO.getNoteDate()+" "+noteDTO.getTimeZone(), formatter);
            note.notetext(noteDTO.getNoteText());
            note.notedate(zonedDateTime.toInstant());
            note.iscomplete(noteDTO.getIscomplete());
            note.client(clientService.getClient(noteDTO.getClient_id()));
            note.project(projectService.getProject(noteDTO.getProject_id()));
            note.notetype(noteTypeService.getNoteType(noteDTO.getNotetype_id()));
            note.created(rightNow);
            note.modified(rightNow);
            noteService.addNote(note);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("note added",HttpStatus.CREATED);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.PUT, value="/notes/{id}")
    public ResponseEntity<String> updateNote(@RequestBody NoteDTO noteDTO, @PathVariable Integer id){
        try{
            EntityNote note = noteService.getNote(id);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		    ZonedDateTime zonedDateTime = ZonedDateTime.parse(noteDTO.getNoteDate()+" "+noteDTO.getTimeZone(), formatter);
            if (note.getNotetext()!=noteDTO.getNoteText()) note.notetext(noteDTO.getNoteText());
            if (note.getIscomplete()!=noteDTO.getIscomplete()) note.iscomplete(noteDTO.getIscomplete());
            note.notedate(zonedDateTime.toInstant());
            note.modified(Instant.now());
            noteService.updateNote(id, note);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("note "+id+" updated",HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.DELETE, value="/notes/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Integer id){
       try{
            noteService.deleteNote(id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("note "+id+" deleted",HttpStatus.OK);
    }

}