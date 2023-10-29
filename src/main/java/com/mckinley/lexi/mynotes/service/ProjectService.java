package com.mckinley.lexi.mynotes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mckinley.lexi.mynotes.model.EntityProject;
import com.mckinley.lexi.mynotes.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    
    public List<EntityProject> getProjectData(){
        List<EntityProject> projectList = new ArrayList<EntityProject>();
        projectRepository.findAll(Sort.by(Sort.Direction.ASC, "name")).forEach(projectList::add);
        return projectList;     
    }

    public EntityProject getProject(int id){return projectRepository.findById(id).orElseThrow(() -> new EntityNotFound(id,"project"));}

    public void addProject(EntityProject project){projectRepository.save(project);}

    public void updateProject(int id, EntityProject project){projectRepository.save(project);}

    public void deleteProject(int id){projectRepository.deleteById(id);}
}