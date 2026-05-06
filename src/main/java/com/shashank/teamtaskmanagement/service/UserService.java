package com.shashank.teamtaskmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.teamtaskmanagement.repository.UserRepository;
import com.shashank.teamtaskmanagement.entity.User;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  User login(String email, String password)
    {
        User user = userRepository.findByEmail(email).orElseThrow(
                ()->new RuntimeException("User Not found"));

        if(!user.getPassword().equals(password))
        {
            throw  new RuntimeException("Invalid Password");
        }
        return  user;
    }

    public User register(User user)
    {
        return userRepository.save(user);
    }
}
