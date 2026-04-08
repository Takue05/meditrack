package com.takue.meditrack.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

public record UserDto(String userId, String username,
    @JsonIgnore String passwordHash, String email, String role){
}
