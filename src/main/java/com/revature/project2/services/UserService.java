package com.revature.project2.services;

import java.util.List;

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
		if (ud.checkEmailExist(u.getEmail()).size() > 0) {
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
		User trueUser = ud.getUserById(u.getCustomer_id());
		if (!u.getPass().equals(trueUser.getPass())) {
			String hasedPW = BCrypt.hashpw(u.getPass(), BCrypt.gensalt());
			u.setPass(hasedPW);
		} 
		ud.updateUser(u);
	}
	
	public int authenticateUser(User u) {
		List<User> users = ud.checkEmailExist(u.getEmail());
		if (users.size() < 1) {
			return 0;
		}
		User trueUser = users.get(0);
		if (BCrypt.checkpw(u.getPass(), trueUser.getPass())) {
			return trueUser.getCustomer_id();
		}
		return 0;
	}
}
