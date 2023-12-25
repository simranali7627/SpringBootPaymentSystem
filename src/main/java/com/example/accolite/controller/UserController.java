package com.example.accolite.controller;


import com.example.accolite.exception.UserAlreadyEnrolledException;
import com.example.accolite.exception.UserNotFoundException;
import com.example.accolite.service.AuthenticationService;
import com.example.accolite.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationService service;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollForOfflinePayment(@RequestParam int user_id) {
        try {
            userService.enrollForOfflinePayment(user_id);
            return ResponseEntity.ok("Enrolled for offline payment successfully.");
        } catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (UserAlreadyEnrolledException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already enrolled.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseController> register(@RequestBody RegisterRequestController request){
        return ResponseEntity.ok(service.registerUser(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseController> authenticate(@RequestBody AuthenticationRequestController request){
        return ResponseEntity.ok(service.authenticateUser(request));
    }


}
