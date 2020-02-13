package com.zhengliang.project.services;

import com.zhengliang.project.domain.User;
import com.zhengliang.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


}
