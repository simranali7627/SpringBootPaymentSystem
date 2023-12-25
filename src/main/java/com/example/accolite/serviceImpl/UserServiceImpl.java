package com.example.accolite.serviceImpl;

import com.example.accolite.entity.User;
import com.example.accolite.entity.UserCategory;
import com.example.accolite.entity.VerificationToken;
import com.example.accolite.model.UserModel;
import com.example.accolite.respository.UserRepository;
import com.example.accolite.respository.VerificationTokenRepository;
import com.example.accolite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) {
       User user = new User();
       user.setUserId(userModel.getUserId());
       user.setUserName(userModel.getUserName());

       user.setPassword(userModel.getPassword());
       user.setRegistered(userModel.isRegistered());

       user.setEnrolledAndApproved(userModel.isEnrolledAndApproved());
       user.setWallet(userModel.getWallet());
       user.setEnrolled(userModel.isEnrolled());
//       user.setCategory(UserCategory.valueOf("USER"));
        userRepository.save((user));
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }
}
