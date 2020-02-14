package com.zhengliang.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
public class Activity {

    public Activity(){

    }

    // For an activity
    // Where
    // When
    // What's the activity
    // Who's attending the activity
    // What's the maximum capacity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title required")
    private String title;

    // ActivityType
    private int type;

    // What's the maximum capacity?
    @Max(50)
    private int capacity;

    // About the activity
    private String description;

    // where - could use google Map
    @NotBlank(message = "Location required")
    private String location;
    
    // when
    @JsonFormat()
    private Date startTime;
    @JsonFormat()
    private Date endTime;

    // Who's attending
    //@Size(max=50)
    private String attending;

    @JsonFormat
    private Date created_at;
    @JsonFormat
    private Date updated_on;

    @PrePersist
    public void onSave(){
        created_at = new Date();
    }

    @PreUpdate
    public void onUpdate(){ updated_on = new Date();}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAttending() {
        return attending;
    }

    public void setAttending(String attending) {
        this.attending = attending;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }
}
