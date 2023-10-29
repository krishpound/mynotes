package com.mckinley.lexi.mynotes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mckinley.lexi.mynotes.model.EntityClient;
import com.mckinley.lexi.mynotes.repository.ClientRepository;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    public List<EntityClient> getClientData(){
        List<EntityClient> clientList = new ArrayList<EntityClient>();
        clientRepository.findAll(Sort.by(Sort.Direction.ASC, "name")).forEach(clientList::add);
        return clientList;     
    }

    public EntityClient getClient(int id){return clientRepository.findById(id).orElseThrow(() -> new EntityNotFound(id,"client"));}

    public void addClient(EntityClient client){clientRepository.save(client);}

    public void updateClient(int id, EntityClient client){clientRepository.save(client);}

    public void deleteClient(int id){clientRepository.deleteById(id);}

}