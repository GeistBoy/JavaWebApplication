package com.zhengliang.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username required")
    private String username;
    @NotBlank(message = "Password required")
    private String password;
    @NotBlank(message = "Name required")
    private String name;

    @Max(3)
    private int currentHosting;

    @JsonFormat
    private Date signUpAt;
    @JsonFormat
    private Date lastLoginIn;

    @PrePersist
    public void onSave(){
        signUpAt = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        lastLoginIn = new Date();
    }

    public User(){};


}
