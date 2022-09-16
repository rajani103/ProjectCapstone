package com.stackroute.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "registration")

public class Registration {

	private String name;
	@Id
	private String email;

	// @Pattern(regexp="^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$",message="password
	// must 8 characters, 2 UpperCase, 1 Special Character, 2 Numbers & 3
	// LowerCase")
	private String password;

	private String phoneNo;

	private UserRole userRole;

	private String techTrack;


}
