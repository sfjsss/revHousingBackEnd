package com.revature.project2.daos;

import com.revature.project2.models.User;

public interface UserDao {

	public int createUser(User u);
	public User getUserById(int id);
	public void updateUser(User u);
	public User getUserByEmail(String e);
}
