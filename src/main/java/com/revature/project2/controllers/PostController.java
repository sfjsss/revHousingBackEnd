package com.revature.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.models.Post;
import com.revature.project2.services.PostService;

@RestController 
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService ps;
	
	@GetMapping
	@ResponseBody
	public List<Post> getAllPost(){
		return ps.getAllPost();
	}

}
