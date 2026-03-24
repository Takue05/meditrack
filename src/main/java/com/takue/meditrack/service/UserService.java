package com.takue.meditrack.service;

import com.takue.meditrack.dto.RegisterUserRequest;
import com.takue.meditrack.dto.UserDto;

public interface UserService{

    UserDto registerUser(RegisterUserRequest request);

}
