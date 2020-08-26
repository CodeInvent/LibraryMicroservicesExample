package com.library.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, String>{
	
	Book findByBookName(String bookName);

}
