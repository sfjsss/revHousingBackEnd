package com.revature.project2.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.project2.models.Login;
import com.revature.project2.models.User;
import com.revature.project2.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	 @Autowired
	 UserService userService;
	 
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	   ModelAndView mav = new ModelAndView("login");
	   mav.addObject("login", new Login());
	   return mav;
	  }
	 
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public ModelAndView loginDash(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    
	    User user = userService.validateUser(login);
	    
	    if (null != user) {
	    mav = new ModelAndView("/");
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }

}
