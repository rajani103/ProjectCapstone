package com.stackroute.service;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;

public interface AuthenticationService {
    User saveUser(User user);
    User findByEmailAndPassword(String email , String password) throws UserNotFoundException, UserNotFoundException;
     User findByEmail(String email) throws UserNotFoundException;
}
