package com.takue.meditrack.dto;

public record RegisterUserRequest(String username, String passwordHash, String email, String role) {

}
