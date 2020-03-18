package com.revature.project2.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Transactional
	@Override
	public List<Post> getPostsByZipcode(String zipcode) {
		Session s = sf.getCurrentSession();
		String sql = "select * from post where zipcode like ?";
		Query<Post> q = s.createNativeQuery(sql, Post.class);
		String zipcodePattern = zipcode.substring(0, 3) + "%";
		q.setParameter(1, zipcodePattern);
		List<Post> posts = q.list();
		return posts;
	}

	@Transactional
	@Override
	public Post getPostById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Post.class, id);
	}
	
	

}
