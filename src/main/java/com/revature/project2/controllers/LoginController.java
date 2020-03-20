package com.revature.project2.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.Auth;
import com.revature.project2.models.User;
import com.revature.project2.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService us;
	
	@PostMapping
	public ResponseEntity<User> getUserByEmail(@RequestBody Auth a) {
		String email = a.getEmail();
		String pass = a.getPass();
		User u = us.getUserByEmail(email);
		if (BCrypt.checkpw(pass, u.getPass())) {
		  return new ResponseEntity<>(u, HttpStatus.OK);
		} else {
		  return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
