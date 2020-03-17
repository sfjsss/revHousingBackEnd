package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project2.models.Post;

@Repository
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	@Override
	public Post getPost(int id) {
		Session s = sf.getCurrentSession();
		return (Post) s.get(Post.class, id);
	}
	
	@Transactional
	@Override
	public int createPost(Post p) {
		Session s = sf.getCurrentSession();
		return (int) s.save(p);
	}

}
