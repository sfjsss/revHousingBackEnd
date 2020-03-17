package com.revature.project2.daos;

import com.revature.project2.models.Post;

public interface PostDao {
	
	public int createPost(Post p);
	public Post getPost(int id);

}
