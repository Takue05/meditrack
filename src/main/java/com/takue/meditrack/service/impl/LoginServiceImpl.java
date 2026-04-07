package com.takue.meditrack.service.impl;

import com.takue.meditrack.dto.LoginRequest;
import com.takue.meditrack.model.User;
import com.takue.meditrack.repository.UserRepository;
import com.takue.meditrack.service.LoginService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Boolean authenticate(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (user==null) {
            return false;
        }
        return passwordEncoder.matches(request.getPassword(), user.getPasswordHash());
    }
}
