package com.takue.meditrack.mapper;

import com.takue.meditrack.dto.RegisterUserRequest;
import com.takue.meditrack.dto.UserDto;
import com.takue.meditrack.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "userId", ignore = true)
    User toEntity(RegisterUserRequest registerUserRequest);
}
