package com.apress.prospring2.ch19.domain;

/**
 * @author anirvanc
 */
public class User {

	public String id;
	public String username;
	public String password;
	public String address;

	public User(final String username, final String password, final String address) {
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}
}
