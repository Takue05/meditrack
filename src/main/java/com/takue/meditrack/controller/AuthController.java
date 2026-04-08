package com.takue.meditrack.controller;


import com.takue.meditrack.dto.JwtResponse;
import com.takue.meditrack.dto.LoginRequest;
import com.takue.meditrack.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginRequest request) {
        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var token = jwtService.generateToken(request.email());
        return ResponseEntity.ok(new JwtResponse(token));

    }

    @PostMapping("/validate")
    public boolean validate(@RequestHeader("Authorization") String authHeader){
        var token = authHeader.replace("Bearer ", "");
        return jwtService.validateToken(token);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Void> handleBadCredentialsException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
