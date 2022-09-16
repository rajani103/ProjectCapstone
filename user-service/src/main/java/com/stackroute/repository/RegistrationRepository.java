package com.stackroute.repository;

import com.stackroute.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegistrationRepository extends MongoRepository<Registration,String> {

    List<Registration> findByEmail(String registrationEmail);
    List<Registration>findByTechTrack(String techTrack);
}
