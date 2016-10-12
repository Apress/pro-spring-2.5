package com.apress.prospring2.ch18.sample.service;

import java.util.ArrayList;
import java.util.List;

import com.apress.prospring2.ch18.sample.Book;
import com.apress.prospring2.ch18.sample.Order;
import com.apress.prospring2.ch18.sample.User;


public class DefaultBookShopService implements BookShopService {

	private List<Book> books;
	private List<Book> computer;
	private List<Book> children;
	
	private List<User> users;
	
	public DefaultBookShopService() {
		this.computer = new ArrayList<Book>();
		this.computer.add(new Book(1L, "test", "test author", 12.99));
        this.computer.add(new Book(2L, "Pro Spring 2", "Arthur Author", 23.95));
        this.computer.add(new Book(3L, "Pro Velocity", "John Doe", 12.98));
        this.computer.add(new Book(4L, "Pro Ajax", "Max Mustermann", 1.11));
		
        this.children = new ArrayList<Book>();
        this.children.add(new Book(5L, "Heidi", "Johanna Spyri", 10.00));
        this.children.add(new Book(6L, "The Ugly Duckling", "H.C.Andersen", 5.95));
        this.children.add(new Book(7L, "Matilda", "Roald Dahl", 7.00));
        
    	this.books = new ArrayList<Book>();
    	this.books.addAll(this.computer);
    	this.books.addAll(this.children);
        
        this.users = new ArrayList<User>();
        this.users.add(new User(1L, "Administrator", "admin", "admin", User.ROLE_ADMIN));
        this.users.add(new User(2L, "User", "user", "user", User.ROLE_USER));
	}
	
	public List<Book> findAllBooks() {
		return books;
	}
	
	public List<Book> findAllByCategory(String category) {
		if("children".equalsIgnoreCase(category)) {
			return this.children;
		} else {
			return this.computer;
		}
	}

	public Book findBookById(Long id) {
		return books.get(id.intValue()-1);
	}

	public Order findOrderById(Long id) {
		return null;
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findUserByUsername(String username) {
		return null;
	}

	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
