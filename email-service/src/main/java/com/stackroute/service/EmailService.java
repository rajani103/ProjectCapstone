package com.stackroute.service;

import com.stackroute.model.Email;



public interface EmailService {

    Email sendEmail(Email email);

    Email sendCancelEmail(Email email);
}
