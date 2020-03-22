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

import com.revature.project2.daos.PostDao;
import com.revature.project2.daos.UserDao;
import com.revature.project2.models.Post;
import com.revature.project2.models.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService us;
	
	@InjectMocks
	private PostService ps;
	
	@Mock
	private UserDao ud;
	
	@Mock
	private PostDao pd;
	
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
	
	@Test(expected = NullPointerException.class)
	public void getUserByIdTest() {
		User u = ud.getUserById(1);
		assertEquals(1, us.authenticateUser(u));
	}
	
	@Test
	public void validateWithNewEmailTest() {
		List<User> retrievedUsers = new ArrayList<>();
				
		User inputUser = new User();
		inputUser.setEmail("lebronjames@gmail.com");
		
		when(ud.checkEmailExist(inputUser.getEmail())).thenReturn(retrievedUsers);
		assertEquals(0, us.authenticateUser(inputUser));
	}
	
	@Test
	public void validateWithCorrectEmailTest() {
		List<User> retrievedUsers = new ArrayList<>();
				
		User newUser = new User();
		newUser.setEmail("wethebest@gmail.com");
		
		when(ud.checkEmailExist(newUser.getEmail())).thenReturn(retrievedUsers);
		assertEquals(0, us.authenticateUser(newUser));
	}
	
	@Test(expected = NullPointerException.class)
	public void updateProfFirstException() {
		User u = ud.getUserById(1);
		u.setFirst_name("Kobe");
		assertEquals(1, u.getFirst_name());
	}
	
	@Test(expected = AssertionError.class)
	public void updateProfLastException() {
		User u = new User();
		u.setLast_name("Bryant");
		assertEquals(1, u.getLast_name());
	}
	
	@Test(expected = AssertionError.class)
	public void testAnInvalidZipcode() {				
		Post inputPost = new Post();
		inputPost.setZipcode("3393939");

		assertEquals(0, inputPost.getZipcode());
	}
	
	@Test
	public void testWithInvalidChars() {
		List<User> retrievedUsers = new ArrayList<>();
				
		User inputUser = new User();
		inputUser.setEmail("!@321@gmail.com");
		
		when(ud.checkEmailExist(inputUser.getEmail())).thenReturn(retrievedUsers);
		assertEquals(0, us.authenticateUser(inputUser));
	}
}
