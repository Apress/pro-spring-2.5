package com.apress.prospring2.ch19.service;

/**
 * @author anirvanc
 */
public interface DwrService {
	boolean usernameAvailability(String username);
	boolean confirmPassword(String password, String confirmPassword);
}
