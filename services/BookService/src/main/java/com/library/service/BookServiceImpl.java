package com.library.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.repository.Book;
import com.library.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public ResponseEntity<List<Book>> getbooks() {
		List<Book> books = (List<Book>) bookRepository.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> getBookById(String bookId) {
		return new ResponseEntity<Book>(bookRepository.findById(bookId).get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> returnBook(String bookId, int incrementalCount) {
		Book bookentry = bookRepository.findById(bookId).get();
		if(bookRepository.existsById(bookentry.getBookID())){
			if(bookentry.getTotalCopies() > bookentry.getAvailableCopies()) {
				bookentry.setAvailableCopies(incrementalCount + bookentry.getAvailableCopies());
				return new ResponseEntity<Book>(bookentry,HttpStatus.OK);
			}
	}
	return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
	
}
}
