package com.revature.project2.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.UserDao;
import com.revature.project2.models.User;

@Service
public class UserService {

	@Autowired
	private UserDao ud;
	
	public int createUser(User u) {
		if (ud.checkEmailExist(u.getEmail())) {
			return 0;
		}
		String hashedPW = BCrypt.hashpw(u.getPass(), BCrypt.gensalt());
		u.setPass(hashedPW);
		return ud.createUser(u);
	}
	
	public User getUserById(int id) {
		return ud.getUserById(id);
	}
	
	public void updateUser(User u) {
		ud.updateUser(u);
	}
}
