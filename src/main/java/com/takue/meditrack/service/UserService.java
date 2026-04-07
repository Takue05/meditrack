package com.takue.meditrack.service;

import com.takue.meditrack.dto.RegisterUserRequest;
import com.takue.meditrack.dto.UserDto;
import com.takue.meditrack.model.User;

import java.util.Optional;

public interface UserService{

    UserDto registerUser(RegisterUserRequest request);

    User getCurrentUser();

}
