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

	@SuppressWarnings("rawtypes")
	@Transactional
	@Override
	public void bookmarkPostById(int userId, int postId) {
		Session s = sf.getCurrentSession();
		String sql = "insert into bookmarked_posts (customer_id, post_id) values (?, ?)";
		Query q = s.createNativeQuery(sql);
		q.setParameter(1, userId);
		q.setParameter(2, postId);
		q.executeUpdate();
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	@Override
	public void unBookmarkPostById(int userId, int postId) {
		Session s = sf.getCurrentSession();
		String sql = "delete from bookmarked_posts where customer_id = ? and post_id = ?";
		Query q = s.createNativeQuery(sql);
		q.setParameter(1, userId);
		q.setParameter(2, postId);
		q.executeUpdate();
	}

	@Transactional
	@Override
	public List<Post> getPostsByUserId(int id) {
		Session s = sf.getCurrentSession();
		String sql = "select * from post where creator_id = ?";
		Query<Post> q = s.createNativeQuery(sql, Post.class);
		q.setParameter(1, id);
		List<Post> posts = q.list();
		return posts;
	}

	@Transactional
	@Override
	public void deletePostById(int id) {
		Session s = sf.getCurrentSession();
		String sql = "delete from post where post_id = ?";
		Query<Post> q = s.createNativeQuery(sql, Post.class);
		q.setParameter(1, id);
		q.executeUpdate();
	}

	@Transactional
	@Override
	public void updatePost(Post p) {
		Session s = sf.getCurrentSession();
		s.update(p);
	}

	@Transactional
	@SuppressWarnings("rawtypes")
	@Override
	public void interestPostById(int userId, int postId) {
		Session s = sf.getCurrentSession();
		String sql = "insert into interested_posts (customer_id, post_id) values (?, ?)";
		Query q = s.createNativeQuery(sql);
		q.setParameter(1, userId);
		q.setParameter(2, postId);
		q.executeUpdate();
	}
	
	

}
