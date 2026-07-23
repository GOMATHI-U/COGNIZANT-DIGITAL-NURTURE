package com.cognizant.authentication_service.controller;

import com.cognizant.authentication_service.model.AuthenticationResponse;
import com.cognizant.authentication_service.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        String username = jwtUtil.extractUser(authHeader);

        String token = jwtUtil.generateToken(username);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}