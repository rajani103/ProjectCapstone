package com.stackroute.Config;
import com.stackroute.model.User;
import com.stackroute.service.AuthenticationServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
   @Autowired
   private AuthenticationServiceImpl authenticationService;

   @RabbitListener(queues = RabbitMQConfig.QUEUE)
   public void consumeProfile(User user) {
       System.out.println(user.toString());
      authenticationService.saveUser(user);
   }

}