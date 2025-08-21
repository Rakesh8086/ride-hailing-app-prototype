package com.ridehailingapp.prototype.DTO;

import com.ridehailingapp.prototype.entity.UserType;
import lombok.Data;

@Data
public class UserRegistrationDTO  {

    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private UserType userType;
}