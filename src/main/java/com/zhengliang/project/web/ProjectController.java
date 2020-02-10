package com.zhengliang.project.web;

import com.zhengliang.project.domain.Project;
import com.zhengliang.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> map = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                map.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
        }

        Project project1 = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectID}")
    public ResponseEntity<?> getProjectById(@PathVariable long projectID){
        Project project = projectService.findProject(projectID);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProject(){
        return projectService.findAll();
    }

    @PutMapping("/{id}/{name}")
    public ResponseEntity<String> updateProjectById(@PathVariable long id, @PathVariable String name){
        projectService.updateById(id, name);
        return new ResponseEntity<String>("did", HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable long projectId){
        projectService.deleteProject(projectId);
        return new ResponseEntity<String>("did", HttpStatus.OK);
    }


}
