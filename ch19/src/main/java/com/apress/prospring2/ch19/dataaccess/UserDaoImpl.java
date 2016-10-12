package com.apress.prospring2.ch19.dataaccess;

import com.apress.prospring2.ch19.domain.User;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Anirvan Chakraborty
 */
public class UserDaoImpl implements UserDao {

	/**
	 * Static datasource
	 */
	private static Map<String, User> allUsers = new HashMap<String, User>();

	public Collection<User> getAllUsers() {
		return allUsers.values();
	}

	public void saveUser(final User user) {
		String id = String.valueOf(allUsers.size() + 1);
		user.setId(id);
		if (!usernameExists(user.getUsername())) {
			allUsers.put(user.getUsername(), user);
		} else {
			throw new IllegalArgumentException("Username " + user.getUsername() + " already exists.");
		}
	}

	public User getUser(final String id) {
		return allUsers.get(id);

	}

	public User getUserByUsername(final String username) {
		return allUsers.get(username);
	}

	public void deleteUser(final User user) {
		allUsers.remove(user);
	}

	public boolean usernameExists(final String username) {
		return allUsers.containsKey(username);
	}

	static {
		allUsers.put("janm", new User("janm", "password", "address"));
		allUsers.put("aleksav", new User("aleksav", "password", "address"));
		allUsers.put("anirvanc", new User("anirvanc", "password", "address"));
	}
}
