package com.zhengliang.project.web;

import com.zhengliang.project.domain.Activity;
import com.zhengliang.project.services.ActivityService;
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
@RequestMapping("/Activity")
@CrossOrigin
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // HTTP Methods;

    // POST - Create
    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody Activity activity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> map = new HashMap<>();
            for(FieldError error : bindingResult.getFieldErrors()){
                map.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Activity>(activityService.create(activity), HttpStatus.OK);
    }

    // GET - Read
    @GetMapping("/all")
    public Iterable<Activity> getAll(){return activityService.findAllActivities(); };

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        Activity activity = activityService.findActivity(id);
        return new ResponseEntity<Activity>(activity, HttpStatus.OK);
    }

    // PUT - Update
    @PutMapping("/{id}/location/{location}")
    public ResponseEntity<?> updateLocation(@PathVariable long id, @PathVariable String location){
        Activity activity = activityService.updateLocationById(id, location);
        if(activity == null)
            return new ResponseEntity<String>("Failed to update location", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Activity>(activity, HttpStatus.OK);
    }

    // DELETE - delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        return activityService.deleteById(id);
    }
}