package com.mckinley.lexi.mynotes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mckinley.lexi.mynotes.model.EntityProject;
import com.mckinley.lexi.mynotes.service.ProjectService;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

////helpful commands
////$mvn spring-boot:run
////$mvn clean package <-- package jar into target folder
////this app is deployed as a Windows service called mynotes


@RestController
public class ProjectController {

    @Autowired   
    private ProjectService projectService; 

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    public List <EntityProject> getProjects(){  
        return projectService.getProjectData();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.GET, value="/projects/{id}")
    public EntityProject getProject(@PathVariable Integer id){
        return projectService.getProject(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.POST, value="/projects")
    public ResponseEntity<String> addNoteType(@RequestBody String projectName){
        try{
            EntityProject project = new EntityProject();
            Instant rightNow = Instant.now();
            project.name(projectName.replaceAll("\"", "").replaceAll("^\\s+", "").replaceAll("\\s+$", ""));
            project.created(rightNow);
            project.modified(rightNow);
            projectService.addProject(project);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("project added",HttpStatus.CREATED);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.PUT, value="/projects/{id}")
    public ResponseEntity<String> updateProject(@RequestBody String projectName, @PathVariable Integer id){
        try{
            EntityProject project = projectService.getProject(id);
            project.name(projectName);
            project.modified(Instant.now());
            projectService.updateProject(id, project);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("project "+id+" deleted",HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://localhost:7443","https://crpvms1intgsvct.corp.nychhc.org:8443"})
    @RequestMapping(method = RequestMethod.DELETE, value="/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id){
        try{
            projectService.deleteProject(id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("notetype "+id+" deleted",HttpStatus.OK);
    }

}