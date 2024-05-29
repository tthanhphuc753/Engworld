package com.example.EngWorldBackend.Domain.UserService;

import com.example.EngWorldBackend.Domain.Request.RegistrationRequest;
import com.example.EngWorldBackend.Domain.Model.User.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    List<User> getAllUser();

    User registerUser(RegistrationRequest request);

    Optional<User> findByEmail(String email);


    User findUserByID(long id) throws Exception;


    void deleteUser(long userID);


    void saveUserVerificationToken(User theUser, String verificationToken);


}