package com.stackroute.controller;

import com.stackroute.model.Email;
import com.stackroute.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmailController {


    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/es/sendEmail/booked")
    public ResponseEntity<Email> sendEmail(@RequestBody Email email){
        Email email1 = emailService.sendEmail(email);
        return new ResponseEntity<>(email1, HttpStatus.OK);

    }
    @PostMapping("/es/sendEmail/cancel")
    public ResponseEntity<?> cancelledMail(@RequestBody Email email){
        Email email1 = emailService.sendCancelEmail(email);
        return new ResponseEntity<>(email1,HttpStatus.CONFLICT);
    }
}
