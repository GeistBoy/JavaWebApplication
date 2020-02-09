package com.zhengliang.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name couldn't be blank")
    private String name;


    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_at;

    @PrePersist
    protected void onCreate(){
        created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        update_at = new Date();
    }

    public Project(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
