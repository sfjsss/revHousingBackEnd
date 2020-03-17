package com.revature.project2.daos;

import java.util.List;

import com.revature.project2.models.Post;

public interface PostDao {

	public int CreatePost(Post p);
	public List<Post> getPostsByZipcode(String zipcode);
}
