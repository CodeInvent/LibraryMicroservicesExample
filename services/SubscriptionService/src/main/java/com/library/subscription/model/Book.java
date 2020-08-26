package com.library.subscription.model;

import javax.persistence.Id;

public class Book {
	
	private String bookId;
	private String bookName;
	private String author;
	private int availableCopies;
	private int totalCopies;
	
	public Book() {}
	public Book(String bookId, String bookName, String author, int availableCopies, int totalCopies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.availableCopies = availableCopies;
		this.totalCopies = totalCopies;
	}
	public String getBookID() {
		return bookId;
	}
	public void setBookID(String bookID) {
		this.bookId = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
}
