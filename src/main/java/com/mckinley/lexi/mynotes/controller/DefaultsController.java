package com.mckinley.lexi.mynotes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mckinley.lexi.mynotes.model.EntityDefaults;
import com.mckinley.lexi.mynotes.service.DefaultsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class DefaultsController {

    @Autowired   
    private DefaultsService defaultsService;

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value = "/defaults")
    public List <EntityDefaults> getDefaults(){  
        return defaultsService.getDefaultData();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value="/defaults/{id}")
    public EntityDefaults getDefault(@PathVariable Integer id){
        return defaultsService.getDefault(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.POST, value="/defaults")
    public ResponseEntity<String> addDefault(@RequestBody EntityDefaults defaultsObj){
        try{
            EntityDefaults defaults = new EntityDefaults();
            defaults.client(defaultsObj.getClient());
            defaults.timeZone(defaultsObj.getTimeZone());
            defaultsService.addDefault(defaults);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("defaults added",HttpStatus.CREATED);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.PUT, value="/defaults/{id}")
    public ResponseEntity<String> updateDefault(@RequestBody EntityDefaults defaultsObj, @PathVariable Integer id){
        try{
            EntityDefaults defaults = defaultsService.getDefault(id);
            if (defaults.getClient()!=defaultsObj.getClient()) defaults.client(defaultsObj.getClient());
            if (defaults.getTimeZone()!=defaultsObj.getTimeZone()) defaults.timeZone(defaultsObj.getTimeZone());
            defaultsService.updateDefault(id, defaults);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("note "+id+" updated",HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.DELETE, value="/defaults/{id}")
    public ResponseEntity<String> deleteDefault(@PathVariable Integer id){
        try{
            defaultsService.deleteDefault(id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("note "+id+" deleted",HttpStatus.OK);
    }

}