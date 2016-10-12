package com.apress.prospring2.ch19.dataaccess;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

import com.apress.prospring2.ch19.domain.User;

/**
 * @author Anirvan Chakraborty
 */

public class UserDaoImplTest {

	public UserDao userDao = new UserDaoImpl();

	@Test
	public void getAllUsers() {
		Collection<User> user = this.userDao.getAllUsers();
		assertTrue("Invalid number of users.", user.size() == 3);
	}

	@Test
	public void saveUser() {
		User newUser = new User("newuser", "newuser", "address");
		this.userDao.saveUser(newUser);
		assertTrue("New user not saved!", this.userDao.getAllUsers().size() == 4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void saveUserWithExistingUsername() {
		User newUser = new User("anirvanc", "password", "address");
		this.userDao.saveUser(newUser);
		assertTrue("User saved with existing username!", this.userDao.getAllUsers().size() == 3);
	}
}
