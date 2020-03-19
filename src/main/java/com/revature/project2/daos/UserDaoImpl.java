package com.revature.project2.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public User getUserById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	@Transactional
	@Override
	public void updateUser(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}

	@Transactional
	@Override
	public List<User> checkEmailExist(String email) {
		Session s = sf.getCurrentSession();
		String sql = "select * from customer where email = ?";
		Query<User> q = s.createNativeQuery(sql, User.class);
		q.setParameter(1, email);
		List<User> users = q.list();
		return users;
	}

}
