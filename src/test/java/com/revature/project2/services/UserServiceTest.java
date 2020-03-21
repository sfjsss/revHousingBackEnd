package com.revature.project2.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.project2.daos.UserDao;
import com.revature.project2.models.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService us;
	
	@Mock
	private UserDao ud;
	
	@Test
	public void authenticateUserWithValidCredential() {
		String hashedPW1 = BCrypt.hashpw("password", BCrypt.gensalt());
		User validUser = new User();
		validUser.setPass(hashedPW1);
		validUser.setEmail("alan@l.com");
		validUser.setCustomer_id(1);
		List<User> retrievedUsers = new ArrayList<>();
		retrievedUsers.add(validUser);
				
		User inputUser = new User();
		inputUser.setPass("password");
		inputUser.setEmail("alan@l.com");
		
		when(ud.checkEmailExist(inputUser.getEmail())).thenReturn(retrievedUsers);
		assertEquals(1, us.authenticateUser(inputUser));
	}
	
	@Test
	public void authenticateUserWithInvalidEmail() {
		List<User> retrievedUsers = new ArrayList<>();
				
		User inputUser = new User();
		inputUser.setPass("password");
		inputUser.setEmail("alan@l.com");
		
		when(ud.checkEmailExist(inputUser.getEmail())).thenReturn(retrievedUsers);
		assertEquals(0, us.authenticateUser(inputUser));
	}
	
	@Test
	public void authenticateUserWithInvalidPassword() {
		String hashedPW1 = BCrypt.hashpw("testtest", BCrypt.gensalt());
		User validUser = new User();
		validUser.setPass(hashedPW1);
		validUser.setEmail("alan@l.com");
		validUser.setCustomer_id(1);
		List<User> retrievedUsers = new ArrayList<>();
		retrievedUsers.add(validUser);
				
		User inputUser = new User();
		inputUser.setPass("password");
		inputUser.setEmail("alan@l.com");
		
		when(ud.checkEmailExist(inputUser.getEmail())).thenReturn(retrievedUsers);
		assertEquals(0, us.authenticateUser(inputUser));
	}
}
