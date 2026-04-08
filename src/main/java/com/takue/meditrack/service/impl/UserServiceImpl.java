package com.takue.meditrack.service.impl;

import com.takue.meditrack.config.SecurityConfig;
import com.takue.meditrack.dto.RegisterUserRequest;
import com.takue.meditrack.dto.UserDto;
import com.takue.meditrack.exception.EmailAlreadyRegisteredException;
import com.takue.meditrack.mapper.UserMapper;
import com.takue.meditrack.model.User;
import com.takue.meditrack.repository.UserRepository;
import com.takue.meditrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyRegisteredException("Email is already registered.");
        }
        User user = userMapper.toEntity(request);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }


    @Override
    public User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        var email = (String) authentication.getPrincipal();
        return userRepository.findByEmail(email).orElse(null);

    }
}
