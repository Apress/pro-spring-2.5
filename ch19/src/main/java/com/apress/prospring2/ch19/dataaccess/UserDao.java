package com.apress.prospring2.ch19.dataaccess;

import com.apress.prospring2.ch19.domain.User;

import java.util.Collection;

/**
 * @author anirvanc
 */
public interface UserDao {

	/**
	 * Retrieves all the users
	 * @return Collection of users
	 */
	Collection<User> getAllUsers();

	/**
	 * Saves a User to the datastore
	 * @param user The User object to persist
	 */
	void saveUser(User user);

	/**
	 * Retrieves a user based on the User's identity
	 * @param id The identity of the User
	 * @return The retrieved User
	 */
	User getUser(String id);

	/**
	 * Retrieves a user based on the User's username
	 * @param username The username
	 * @return The retrieved User
	 */
	User getUserByUsername(String username);

	/**
	 * Delete's a User from the datastore
	 * @param user The User to delete
	 */
	void deleteUser(User user);

	/**
	 * Checks whether a username is already taken or not
	 * @param username The username to check
	 * @return True or False based on whether the username is available or not
	 */
	boolean usernameExists(String username);

}
