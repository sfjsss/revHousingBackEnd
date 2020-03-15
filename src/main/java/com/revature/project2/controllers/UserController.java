package com.revature.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.User;
import com.revature.project2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService us;

	@GetMapping
	public String testController() {
		System.out.println("I was hit");
		
		User u = new User();
		u.setFirst_name("tianyu");
		u.setLast_name("li");
		u.setEmail("alandron06281990@gmail.com");
		u.setPhone("6268237713");
		u.setPass("password");
		u.setGender("male");
		us.createUser(u);
		
		return "this worked";
	}
}
