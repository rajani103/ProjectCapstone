package com.stackroute.service;

import com.stackroute.exception.ResourceNotFoundException;
import com.stackroute.model.Registration;

import java.util.List;

public interface RegistrationService {

     Registration newRegistration(Registration registration);
     List<Registration> getAllUsers();
     List<Registration> getByEmail(String registrationEmail);
     Registration updateRegistration(Registration registration);
     String removebyemail(String email) throws ResourceNotFoundException;
     List<Registration> findByTechTrack(String techTrack);
}
