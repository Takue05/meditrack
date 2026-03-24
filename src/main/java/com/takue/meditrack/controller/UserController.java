package com.takue.meditrack.controller;

import com.takue.meditrack.dto.RegisterUserRequest;
import com.takue.meditrack.dto.UserDto;
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

    @PostMapping
    public ResponseEntity<?> registerUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
    ) {
        UserDto userDto = userService.registerUser(request);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getUserId()).toUri();
        return ResponseEntity.created(uri).body(userDto);

    }
}
