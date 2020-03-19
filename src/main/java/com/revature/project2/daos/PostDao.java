package com.revature.project2.daos;

import java.util.List;

import com.revature.project2.models.Post;

public interface PostDao {

	public int CreatePost(Post p);
	public List<Post> getPostsByZipcode(String zipcode);
	public Post getPostById(int id);
	public void bookmarkPostById(int userId, int postId);
	public void unBookmarkPostById(int userId, int postId);
	public List<Post> getPostsByUserId(int id);
	public void deletePostById(int id);
	public void updatePost(Post p);
	public void interestPostById(int userId, int postId);
	public void unInterestPostById(int userId, int postId);
}
