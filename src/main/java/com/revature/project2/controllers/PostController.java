package com.revature.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.Post;
import com.revature.project2.models.User;
import com.revature.project2.services.PostService;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Integer> createPost(@RequestBody Post post) {		
		User user = new User();
		user.setCustomer_id(2);
		post.setCreator(user);
		int postId = postService.createPost(post);
		return new ResponseEntity<>(postId, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> getPostsByZipcode(@RequestParam("zipcode") String zipcode) {
		List<Post> posts = postService.getPostsByZipcode(zipcode);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") int id) {
		Post post = postService.getPostById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@GetMapping("/bookmark")
	public ResponseEntity<String> bookmarkPostById(@RequestParam("userId") String userId, @RequestParam("postId") String postId) {
		postService.bookmarkPostById(Integer.parseInt(userId), Integer.parseInt(postId));
		return new ResponseEntity<>("bookmarked a post", HttpStatus.OK);
	}
}
