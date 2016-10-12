package com.apress.prospring2.ch18.sample;

import java.io.Serializable;

public class User implements Serializable{

	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String username;
	private String password;
	private String role;
	
	public User() {
	}

	public User(Long id, String name, String username, String password, String role) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
