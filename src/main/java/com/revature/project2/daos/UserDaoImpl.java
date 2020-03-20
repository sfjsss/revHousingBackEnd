package com.revature.project2.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project2.models.Login;
import com.revature.project2.models.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	@Override
	public User createUser(User u) {
		Session s = sf.getCurrentSession();
		User createUser = (User) s.save(u);
		return createUser;
	}

	@Override
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
