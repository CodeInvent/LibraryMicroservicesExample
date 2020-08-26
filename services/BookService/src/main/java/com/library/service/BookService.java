package com.library.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.library.repository.Book;

public interface BookService {
	ResponseEntity<List<Book>> getbooks();
	ResponseEntity<Book> getBookById(String bookId);
	ResponseEntity<Book> returnBook(String bookId, int incrementalCount);
}
