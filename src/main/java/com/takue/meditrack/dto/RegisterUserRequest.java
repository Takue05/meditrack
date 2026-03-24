package com.takue.meditrack.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String username;
    private  String passwordHash;
    private String email;
    private String role;
}
