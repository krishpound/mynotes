package com.mckinley.lexi.mynotes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mckinley.lexi.mynotes.model.EntityClient;
import com.mckinley.lexi.mynotes.service.ClientService;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ClientController {

    @Autowired   
    private ClientService clientService;

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value = "/clients")
    public List <EntityClient> getClients(){  
        return clientService.getClientData();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value="/clients/{id}")
    public EntityClient getClient(@PathVariable Integer id){
        return clientService.getClient(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.POST, value="/clients")
    public ResponseEntity<String> addClient(@RequestBody String clientName){
        try{
            EntityClient client = new EntityClient();
            Instant rightNow = Instant.now();
            client.name(clientName.replaceAll("\"", "").replaceAll("^\\s+", "").replaceAll("\\s+$", ""));
            client.created(rightNow);
            client.modified(rightNow);
            clientService.addClient(client);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("client added",HttpStatus.CREATED);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.PUT, value="/clients/{id}")
    public ResponseEntity<String> updatePatient(@RequestBody String clientName, @PathVariable Integer id){
        try{
            EntityClient client = clientService.getClient(id);
            client.name(clientName);
            client.modified(Instant.now());
            clientService.updateClient(id, client);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("client "+id+" updated",HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.DELETE, value="/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id){
        try{
            clientService.deleteClient(id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("note "+id+" deleted",HttpStatus.OK);
    }

}