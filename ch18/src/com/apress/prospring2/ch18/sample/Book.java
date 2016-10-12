package com.apress.prospring2.ch18.sample;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String CATEGORY_COMPUTER = "Computer";
	public static final String CATEGORY_CHILDREN = "Children";

	private Long id;
	private String title;
	private String author;
	private String description;
	private String image;
	private Double price;
	private Date addingDate;
	
	public Book() {
	}
	
	public Book(Long id, String title, String author, Double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.addingDate = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getAddingDate() {
		return addingDate;
	}
	public void setAddingDate(Date addingDate) {
		this.addingDate = addingDate;
	}
	
}
