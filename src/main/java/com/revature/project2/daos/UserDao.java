package com.revature.project2.daos;

import com.revature.project2.models.Login;
import com.revature.project2.models.User;

public interface UserDao {

	public User createUser(User u);

	User validateUser(Login login);
}
