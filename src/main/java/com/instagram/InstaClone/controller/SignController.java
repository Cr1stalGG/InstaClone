package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.security.AuthenticationRequest;
import com.instagram.InstaClone.security.AuthenticationResponse;
import com.instagram.InstaClone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {
    private final UserService userService;

    @PostMapping("/up")
    public ResponseEntity<AuthenticationResponse> registration(@RequestBody UserRegistrationRequest userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @PostMapping("/in")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
