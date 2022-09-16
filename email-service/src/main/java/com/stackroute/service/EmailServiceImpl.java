package com.stackroute.service;

import com.stackroute.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{


    @Autowired
   private JavaMailSender javaMailSender;



    @Override
    public Email sendEmail(Email email) {
        try {

            System.out.println(email.toString());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getInterviewerEmail());
            message.setSubject(email.getSubject());
            String date = email.getDate();
            String startTime = email.getStartTime();
            String endTime = email.getEndTime();
            String link = email.getLink();

            message.setText("Hi " + email.getInterviewerEmail().split("@")[0] + ",\n\n" + "Greeting from BookYourSlot, \nYour slot is booked successfully.\nPlease ensure your availability for the following Schedule-" +"\nTag-Team-Name "+email.getTagTeamName()+"\nInterview Topic "+email.getSubject()+
                    "\nBooked Date\t:\t" + date + "\nStart Time \t:\t" + startTime + "\nEnd Time   \t:\t" + endTime + "\n\n" + link + "\n\n" + "Thanks & Regards\nBookYourSlot Corp. Ltd.");

            javaMailSender.send(message);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return email;
    }

    @Override
    public Email sendCancelEmail(Email email) {

        System.out.println(email.toString());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getInterviewerEmail());
        message.setSubject(email.getSubject());
        String date = email.getDate();
        String startTime = email.getStartTime();
        String endTime = email.getEndTime();
        String link = email.getLink();
        message.setText("Hi " + email.getInterviewerEmail().split("@")[0] + ",\n\n" + "Greeting from BookYourSlot, \nYour slot is booked successfully.\nPlease ensure your availability for the following Schedule-" +"\nTag-Team-Name "+email.getTagTeamName()+"\nInterview Topic "+email.getSubject()+
                "\nBooked Date\t:\t" + date + "\nStart Time \t:\t" + startTime + "\nEnd Time   \t:\t" + endTime + "\n\n" + link+ "\n\n" + "Thanks & Regards\nBookYourSlot Corp. Ltd.");


        javaMailSender.send(message);
        return email;
    }
}
