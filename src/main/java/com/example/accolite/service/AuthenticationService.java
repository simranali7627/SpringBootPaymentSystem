package com.example.accolite.service;


import com.example.accolite.config.JwtService;
import com.example.accolite.controller.AuthenticationRequestController;
import com.example.accolite.controller.AuthenticationResponseController;
import com.example.accolite.controller.RegisterRequestController;
import com.example.accolite.entity.User;
import com.example.accolite.entity.UserCategory;
import com.example.accolite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    @Autowired
    UserRepository repository;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthenticationResponseController registerUser(RegisterRequestController request) {
        User user = new User();
        user.setUserId(request.getUser_id());
        user.setUserName(request.getUser_name());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserSecret(generateUserSecret());
        user.setRegistered(true);
        user.setEnrolled(false);
        user.setEnrolledAndApproved(false);
        user.setLatitude(request.getLatitude());
        user.setLongitude(request.getLongitude());
        user.setCategory(UserCategory.USER);
        repository.save(user);
        var jwtToken = jwtService.generateToken((UserDetails) user);
        AuthenticationResponseController authenticationResponse = new AuthenticationResponseController();
        authenticationResponse.setToken(jwtToken);
        return authenticationResponse;
    }

    public AuthenticationResponseController authenticateUser(AuthenticationRequestController request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUser_name(), request.getPassword()));
        User user = repository.findByName(request.getUser_name()).orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        AuthenticationResponseController authenticationResponse = new AuthenticationResponseController();
        authenticationResponse.setToken(jwtToken);
        return authenticationResponse;
    }

    public String generateUserSecret(){
        return UUID.randomUUID().toString();
    }

}
