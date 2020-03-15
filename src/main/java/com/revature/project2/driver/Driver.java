package com.revature.project2.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.project2.models.User;
import com.revature.project2.services.UserService;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) ac.getBean("userService");
		
		User u = new User();
		u.setFirst_name("tianyu");
		u.setLast_name("li");
		u.setEmail("alandron06281990@gmail.com");
		u.setPhone("6268237713");
		u.setPass("password");
		u.setGender("male");
		
		int result = us.createUser(u);
		System.out.println(result);
	}
}
