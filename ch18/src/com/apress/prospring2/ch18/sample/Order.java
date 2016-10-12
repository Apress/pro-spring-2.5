package com.apress.prospring2.ch18.sample;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private Long id;
	private User user;
	private Book book;
	private Address billingAddress;
	private Address shippingAddress;
	private CreditCard creditCard;

	public Order() {
		this.billingAddress = new Address();
		this.shippingAddress = new Address();
		this.creditCard = new CreditCard();
	}
	
	public Order(User user, Book book) {
		super();
		this.user = user;
		this.book = book;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
