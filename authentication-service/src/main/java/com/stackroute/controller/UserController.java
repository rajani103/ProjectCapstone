package com.stackroute.controller;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;
import com.stackroute.service.AuthenticationService;
import com.stackroute.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private ResponseEntity responseEntity;
    private AuthenticationService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    //This is User controller class

    @Autowired
    public UserController(AuthenticationService authenticationService, SecurityTokenGenerator securityTokenGenerator)
    {
        this.userService = authenticationService;
        this.securityTokenGenerator=securityTokenGenerator;

    }
    //This is login for mapping for user using which user can login using the credentials
    @PostMapping("/auth/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map = null;
        try {
            User userObj = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userObj.getEmail().equals(user.getEmail())) {
                map=securityTokenGenerator.generateToken(userObj);
            }
            responseEntity = new ResponseEntity(map,HttpStatus.OK);
            System.out.println(userObj);
        }
        catch(UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/auth/findByEmail/{email}")
    public ResponseEntity<User> findByEmailAndPassword(@PathVariable("email") String email) throws UserNotFoundException {
        User byEmail =userService.findByEmail(email);
        return new ResponseEntity<>(byEmail, HttpStatus.OK);
    }
}


