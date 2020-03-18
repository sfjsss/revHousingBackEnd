package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project2.models.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	@Override
	public int createUser(User u) {
		Session s = sf.getCurrentSession();
		int result = (int) s.save(u);
		return result;
	}
	
	@Transactional
	@Override
	public User updateUser(User u) {
		Session s = sf.getCurrentSession();
		User updatedUser = (User) s.merge(u);
		return updatedUser;
	}
	
}
