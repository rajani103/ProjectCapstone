package com.stackroute.controller;
import com.stackroute.model.Registration;
import com.stackroute.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

         //CREATE REGISTRATION DETAILS//localhost:8080/api/v1/registration.........//POST
    @PostMapping("/reg/registration")
	public ResponseEntity<Registration> newRegistration(@Valid @RequestBody Registration registration ) {
            registrationService.newRegistration(registration);
		return new ResponseEntity<>(registrationService.newRegistration(registration), HttpStatus.ACCEPTED);
	}

    //FETCH REGISTERED USERS//localhost:8080/api/v1/getall.....//GET
    @GetMapping("/reg/getall")
    public ResponseEntity<List<Registration> >getAllUsers() {
    List<Registration> newList = registrationService.getAllUsers();
        return new ResponseEntity<>(newList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/reg/getbyemail/{email}")
    public ResponseEntity<List<Registration>> getByEmail(@PathVariable("email") String registrationEmail)
           {
       List<Registration> listbyemail  = registrationService.getByEmail(registrationEmail);
               return new ResponseEntity<>(listbyemail,HttpStatus.ACCEPTED);
           }

    //UPDATE//localhost:8080/api/v1/get/email/pink@gmail.com//GET
    @PutMapping("/reg/updatebyemail/{email}")

    public ResponseEntity<Registration> updateRegistration(@RequestBody Registration registration, @PathVariable("email") String email) {
       registration.setEmail(email);
       return new ResponseEntity<>(registrationService.updateRegistration(registration), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/reg/deletebyemail/{email}")
    public String removebyemail(@PathVariable("email") String email)
    {
        String removebyemail = registrationService.removebyemail(email);
        return removebyemail;
    }

    @GetMapping("/reg/getByTechTrack/{techTrack}")
    public ResponseEntity<List<Registration>> findByTechTrack(@PathVariable("techTrack") String techTrack)  {
        List<Registration> byTechTrack = registrationService.findByTechTrack(techTrack);
        return new ResponseEntity<>(byTechTrack, HttpStatus.OK);
}}
