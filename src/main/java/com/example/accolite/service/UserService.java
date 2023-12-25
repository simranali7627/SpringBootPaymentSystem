package com.example.accolite.service;

import com.example.accolite.entity.User;
import com.example.accolite.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
