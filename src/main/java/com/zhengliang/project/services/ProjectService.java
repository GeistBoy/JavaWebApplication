package com.zhengliang.project.services;

import com.zhengliang.project.domain.Project;
import com.zhengliang.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        // some logic here

        return projectRepository.save(project);
    }
}
