package com.revature.project2.authcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.User;
import com.revature.project2.services.UserService;

@RestController
@CrossOrigin
public class AuthController {

	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public ResponseEntity<Integer> registerUser(@RequestBody User u) {
		Integer result = us.createUser(u);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> loginUser(@RequestBody User u) {
		Integer result = us.authenticateUser(u);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
