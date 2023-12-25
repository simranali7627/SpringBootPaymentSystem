package com.example.accolite.serviceImpl;


import com.example.accolite.entity.User;
import com.example.accolite.exception.UserAlreadyEnrolledException;
import com.example.accolite.exception.UserNotFoundException;
import com.example.accolite.repository.UserRepository;
import com.example.accolite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${jwt.secret}")
    String jwtSecret;

    public User registerUser(int user_id, String user_name, String address, Double latitude, Double longitude) throws UnsupportedEncodingException {
//        GeoLocation location = getGeoLocation(address);

        User user = new User();
        user.setUserId(user_id);
        user.setUserName(user_name);
        user.setUserSecret(generateUserSecret());
        user.setRegistered(true);
        user.setEnrolled(false);
        user.setEnrolledAndApproved(false);
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        userRepository.save(user);

        return user;
    }

    public Boolean enrollForOfflinePayment(int user_id){
        Optional<User> user = userRepository.findById(user_id);
        if(user.isPresent()){
            User currUser = user.get();
            if(!currUser.getUser_enrolled()){
                currUser.setUser_enrolled(true);
                userRepository.save(currUser);
                return true;
            }
            throw new UserAlreadyEnrolledException("User is already enrolled");
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public User approveUser(int user_id){
        Optional<User> user = userRepository.findById(user_id);
        if(user.isPresent()){
            User currUser = user.get();
            if(!currUser.getUser_enrollapproved()){
                currUser.setUser_enrollapproved(true);
                userRepository.save(currUser);
                return currUser;
            }
            throw new UserAlreadyEnrolledException("User is already approved");
        }
        throw new UserNotFoundException("User not found");
    }



    public String generateUserSecret(){
        return UUID.randomUUID().toString();
    }

}
