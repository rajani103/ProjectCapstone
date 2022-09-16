package com.stackroute.service;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;
import com.stackroute.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepo userRepo;
    @Autowired
    public AuthenticationServiceImpl(UserRepo userRepository){
        this.userRepo = userRepository;

    }

    //This method updates the user details.
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
    //This is implemetation method of finding user by email id and password
    @Override
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user =  userRepo.findByEmailAndPassword(email, password);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    public User findByEmail(String email) throws UserNotFoundException{
        User byID= userRepo.findById(email).get();
        if(byID==null){
            throw new UserNotFoundException();
        }
        return byID;

    }
}



