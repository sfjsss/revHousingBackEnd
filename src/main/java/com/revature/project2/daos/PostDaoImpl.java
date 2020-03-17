package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project2.models.Post;

@Repository
public class PostDaoImpl implements PostDao {
	
	@Autowired
	private SessionFactory sf;

	@Transactional
	@Override
	public int CreatePost(Post p) {
		Session s = sf.getCurrentSession();
		return (int) s.save(p);
	}

}
