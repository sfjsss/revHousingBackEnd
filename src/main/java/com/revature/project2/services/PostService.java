package com.revature.project2.services;

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
}
