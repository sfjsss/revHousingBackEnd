package com.revature.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<User> createUser(@RequestBody User user) {		
		User createUser = us.createUser(user);
		return new ResponseEntity<>(createUser, HttpStatus.ACCEPTED);
	}
//	@GetMapping
//	public String testController() {
//		System.out.println("I was hit");
//		
//		User u = new User();
//		u.setFirst_name("tianyu");
//		u.setLast_name("li");
//		u.setEmail("alandron06281990@gmail.com");
//		u.setPhone("6268237713");
//		u.setPass("password");
//		u.setGender("male");
//		us.createUser(u);
//		
//		return "this worked";
//	}
}
