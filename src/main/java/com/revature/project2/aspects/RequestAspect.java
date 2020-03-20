package com.revature.project2.aspects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.project2.daos.UserDao;
import com.revature.project2.models.User;

@Component
@Aspect
public class RequestAspect {
	
	@Autowired
	UserDao ud;

	@Around("within(com.revature.project2.controllers.*)")
	public Object authorizeRequest(ProceedingJoinPoint jp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		System.out.println("aspect has been executed");
		if (request.getHeader("userId") == null) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		} else {
			Integer userId = Integer.parseInt(request.getHeader("userId"));
			User u = ud.getUserById(userId);
			if (u == null) {
				return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			}
			return jp.proceed();
		}
	}
	
}
