package com.stackroute.model;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Entity
public class User {
       @Id
        private String email;
        private String password;
        private UserRole userRole;



}

