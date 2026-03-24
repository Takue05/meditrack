package com.takue.meditrack.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String username;

    @JsonIgnore
    private  String passwordHash;

    private String email;
    private String role;
}
