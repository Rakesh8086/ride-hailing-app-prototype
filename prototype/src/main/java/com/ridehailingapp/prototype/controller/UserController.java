package com.ridehailingapp.prototype.controller;

import com.ridehailingapp.prototype.DTO.UserRegistrationDTO; // Add this line
import com.ridehailingapp.prototype.entity.User;
import com.ridehailingapp.prototype.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Validated @RequestBody UserRegistrationDTO registrationData) {
        try {
            User registeredUser = userService.registerUser(registrationData.getName(),
            registrationData.getEmail(), registrationData.getPassword(),
            registrationData.getPhoneNumber(), registrationData.getUserType());
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}