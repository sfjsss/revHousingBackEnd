package com.revature.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.Post;
import com.revature.project2.models.User;
import com.revature.project2.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<String> createPost(@RequestBody Post post) {
		System.out.println("/posts post is triggered");
		
		User user = new User();
		user.setCustomer_id(2);
		post.setCreator(user);
		int postId = postService.createPost(post);
		return new ResponseEntity<>("A new post with id: " + postId + " has been created", HttpStatus.CREATED);
	}
}
