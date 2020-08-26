package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.repository.Book;

@RestController
public class BookServiceRestControl {
	
	@Autowired
	private BookServiceImpl bookserviceImpl;
	
	@RequestMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		return bookserviceImpl.getbooks();
	}
	
	@RequestMapping("/books/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId")String Id) {
		return bookserviceImpl.getBookById(Id);
	}
	
	@PostMapping("/books/UpdateAvailability/{bookId}/{incremental_count}")
	public ResponseEntity<Book> ReturnBook(@PathVariable("bookId")String bookId, 
			@PathVariable("incremental_count") int incremental_count) {
		return bookserviceImpl.returnBook(bookId, incremental_count);
	}
}
