package com.ridehailingapp.prototype.service;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridehailingapp.prototype.Repository.UserRepository;
import com.ridehailingapp.prototype.entity.User;
import com.ridehailingapp.prototype.entity.UserType;

@Service
// Every single step of the process has to saved in DB
// After updation, the updated state of the entity has to set using SET method
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String userName, String email, String password, 
    String phoneNumber, UserType userType){
        if(userRepository.findByPhoneNumber(phoneNumber).isPresent()){
            throw new RuntimeException("Phone number already registered");
        }
        
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPasswordHash(password);
        user.setPhoneNumber(phoneNumber);
        user.setUserType(userType);
        user.setCreatedAt(LocalDateTime.now());

       return userRepository.save(user);
    }
}