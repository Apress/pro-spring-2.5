package com.apress.prospring2.ch19.service;

import com.apress.prospring2.ch19.dataaccess.UserDao;

/**
 * @author anirvanc
 */
public final class DefaultDwrService implements DwrService{

	private UserDao userDao;

	public boolean usernameAvailability(final String username) {
		return !this.userDao.usernameExists(username);
	}

	public boolean confirmPassword(final String password, final String confirmPassword) {
		return password.equals(confirmPassword);
	}

	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}
}
