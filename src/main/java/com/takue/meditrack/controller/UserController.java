package com.takue.meditrack.controller;

import com.takue.meditrack.dto.RegisterUserRequest;
import com.takue.meditrack.dto.UserDto;
import com.takue.meditrack.mapper.UserMapper;
import com.takue.meditrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<?> registerUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
    ) {
        UserDto userDto = userService.registerUser(request);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.userId()).toUri();
        return ResponseEntity.created(uri).body(userDto);

    }

    @RequestMapping("/me")
    public ResponseEntity<UserDto> me(){
        if(userService.getCurrentUser() == null){
            return ResponseEntity.notFound().build();
        }
        UserDto dto = userMapper.toDto(userService.getCurrentUser());
        return ResponseEntity.ok(dto);


    }
}
