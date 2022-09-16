package com.stackroute.service;

import com.stackroute.exception.ResourceNotFoundException;
import com.stackroute.model.Registration;
import com.stackroute.rabbitmq.RabbitMqConfig;
import com.stackroute.rabbitmq.UserDto;
import com.stackroute.repository.RegistrationRepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private DirectExchange directExchange;
    @Override
    public Registration newRegistration(Registration registration) {
        UserDto userDto = new UserDto();
        userDto.setEmail(registration.getEmail());
        userDto.setPassword(registration.getPassword());
        userDto.setUserRole(registration.getUserRole());
        template.convertAndSend(directExchange.getName(), RabbitMqConfig.ROUTING_KEY,userDto);
        return registrationRepository.save(registration);
    }

    @Override
    public List<Registration> getAllUsers() {
        List<Registration> listallusers = registrationRepository.findAll();
        return listallusers;
    }

    @Override
    public List<Registration> getByEmail(String registrationEmail) {
        List<Registration> listbyemail = registrationRepository.findByEmail(registrationEmail);
        return listbyemail;
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        Optional<Registration> byId = registrationRepository.findById(registration.getEmail());
            Registration updateReg = byId.get();
            updateReg.setName(registration.getName());
            updateReg.setPassword(registration.getPassword());
            updateReg.setPhoneNo(registration.getPhoneNo());
            updateReg.setTechTrack(registration.getTechTrack());
            updateReg.setUserRole(registration.getUserRole());
            registrationRepository.save(updateReg);
            return updateReg;
        }

    @Override
    public String removebyemail(String email) throws ResourceNotFoundException {
        try {
           //Registration byEmail = registrationRepository.findByEmail(email);
            List<Registration> byEmail = registrationRepository.findByEmail(email);
            System.out.println(byEmail);
            if (byEmail.isEmpty()) {
                return "Email Not Found";
            }

            else {
                registrationRepository.deleteById(email);
                return "Deleted Successfully";
              //  throw new RuntimeException("User Registration is not available with this emailid " + email);
                        }
        }
        catch (Exception exception) {
             throw new ResourceNotFoundException("User Registration  not exists with emailid " + email);
        }
    }

    @Override
    public List<Registration> findByTechTrack(String techTrack){
        if(registrationRepository.findByTechTrack(techTrack).isEmpty())
            throw new RuntimeException(" No Data Found ! ");
        else
            return registrationRepository.findByTechTrack(techTrack);
    }

}