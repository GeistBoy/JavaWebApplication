package com.zhengliang.project.services;

import com.zhengliang.project.domain.Activity;
import com.zhengliang.project.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.activation.ActivationID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // CRUD

    // Create
    public Activity create(Activity activity){
        // do some validation here

        return activityRepository.save(activity);
    }

    // Read
    public Activity findActivity(long id){
        return activityRepository.findById(id);
    }

    public Iterable<Activity> findAllActivities(){
        return activityRepository.findAll();
    }

    // Update
    public Activity updateLocationById(long id, String location){
        Activity activity = findActivity(id);
        if(activity != null){
            activity.setLocation(location);
            activityRepository.save(activity);
        }
        return activity;
    }


    // Delete
    public ResponseEntity<String> deleteById(long id){
        Activity activity = this.findActivity(id);
        if(activity == null){
            return new ResponseEntity<String>("Doesn't exist", HttpStatus.BAD_REQUEST);
        }else{
            activityRepository.deleteById(id);
            return new ResponseEntity<String>("Deleted", HttpStatus.OK);
        }
    }
}
