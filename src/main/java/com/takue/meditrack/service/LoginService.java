package com.takue.meditrack.service;

import com.takue.meditrack.dto.LoginRequest;

public interface LoginService {
    Boolean authenticate(LoginRequest request);
}
