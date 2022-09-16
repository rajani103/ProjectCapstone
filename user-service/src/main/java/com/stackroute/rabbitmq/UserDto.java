package com.stackroute.rabbitmq;
import com.stackroute.model.UserRole;
import lombok.*;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class UserDto {
        private String email;
        private String password;
        private UserRole userRole;

    }

