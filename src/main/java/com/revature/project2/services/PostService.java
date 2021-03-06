package com.revature.project2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.PostDao;
import com.revature.project2.models.Post;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	public int createPost(Post p) {
		return postDao.CreatePost(p);
	}
	
	public List<Post> getPostsByZipcode(String zipcode) {
		return postDao.getPostsByZipcode(zipcode);
	}
	
	public Post getPostById(int id) {
		return postDao.getPostById(id);
	}
	
	public void bookmarkPostById(int userId, int postId) {
		postDao.bookmarkPostById(userId, postId);
	}
	
	public void unBookMarkPostById(int userId, int postId) {
		postDao.unBookmarkPostById(userId, postId);
	}
	
	public List<Post> getPostsByUserId(int id) {
		return postDao.getPostsByUserId(id);
	}
	
	public void deletePostById(int id) {
		postDao.deletePostById(id);
	}
	
	public void updatePost(Post p) {
		postDao.updatePost(p);
	}
	
	public void interestPostById(int userId, int postId) {
		postDao.unBookmarkPostById(userId, postId);
		postDao.interestPostById(userId, postId);
	}
	
	public void unInterestPostById(int userId, int postId) {
		postDao.unInterestPostById(userId, postId);
	}
}
