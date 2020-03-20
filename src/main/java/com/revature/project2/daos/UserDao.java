package com.revature.project2.daos;

import java.util.List;

import com.revature.project2.models.User;

public interface UserDao {

	public int createUser(User u);
	public List<User> checkEmailExist(String email);
	public User getUserById(int id);
	public void updateUser(User u);
}
