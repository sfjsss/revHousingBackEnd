package com.revature.project2.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.project2.models.Post;
import com.revature.project2.models.User;
import com.revature.project2.services.PostService;
import com.revature.project2.services.UserService;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostService ps = (PostService) ac.getBean("postService");
//        UserService us = (UserService) ac.getBean("userService");
//		
//		User u = new User();
//		u.setFirst_name("tianyu");
//		u.setLast_name("li");
//		u.setEmail("alandron06281990@gmail.com");
//		u.setPhone("6268237713");
//		u.setPass("password");
//		u.setGender("male");
		Post p = ps.getPost(1);
		
//		Post p = new Post("Liv+", "2000", "1001 South st", "76001", "Coronavirus place, but lovely place though", "www.pic.com", "www.pic.com", "www.pic.com");
//		int pk = ps.createPost(p);
//		int result = us.createUser(u);
//		System.out.println(result);
//		System.out.println(pk);
		System.out.println(p);
	}
}
