package com.apress.prospring2.ch18.sample.service;

import java.util.List;

import com.apress.prospring2.ch18.sample.Book;
import com.apress.prospring2.ch18.sample.Order;
import com.apress.prospring2.ch18.sample.User;

public interface BookShopService {

	List<Book> findAllBooks();
	
	List<Book> findAllByCategory(String category);
	
	Book findBookById(Long id);
	
	List<User> findAllUsers();
	
	User findUserByUsername(String username);
	
	void saveOrder(Order order);
	
	Order findOrderById(Long id);
	
}
