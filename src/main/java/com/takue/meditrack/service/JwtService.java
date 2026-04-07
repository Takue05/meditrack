package com.takue.meditrack.service;

public interface JwtService {
    String generateToken(String email);
    boolean validateToken(String token);
    String getEmailFromToken(String token);
}
