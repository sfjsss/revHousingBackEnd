package com.revature.project2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.project2.models.User;
import com.revature.project2.services.UserService;

@RestController 
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<User> updateUser(@RequestBody User user) {		
		User updatedUser = us.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
	}

}
