package com.revature.project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.UserDao;
import com.revature.project2.models.Login;
import com.revature.project2.models.User;

@Service
public class UserService {

	@Autowired
	private UserDao ud;
	
	public User createUser(User u) {
		return ud.createUser(u);
	}
	 public User validateUser(Login login) {
		return ud.validateUser(login);
	}
}
