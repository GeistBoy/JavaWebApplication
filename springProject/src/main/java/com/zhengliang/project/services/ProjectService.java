package com.zhengliang.project.services;

import com.zhengliang.project.domain.Project;
import com.zhengliang.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // create
    public Project saveOrUpdate(Project project){
        // some logic here

        return projectRepository.save(project);
    }

    // read
    public Project findProject(long id){
        return projectRepository.findById(id);
    }

    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }

    // update
    public void updateById(long id, String name){
        Project target = projectRepository.findById(id);
        if(target != null){
            target.setName(name);
            projectRepository.save(target);
        }
    }


    // delete
    public void deleteProject(long id){
        Project target = findProject(id);
        if(target != null){
            projectRepository.deleteById(id);
        }
    }
}
