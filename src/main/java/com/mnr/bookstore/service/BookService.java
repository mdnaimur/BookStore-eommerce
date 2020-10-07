package com.mnr.bookstore.service;

import java.util.List;

import com.mnr.bookstore.model.Book;



public interface BookService {
	
	Book save(Book book);
	List<Book> findAll();
	Book findOne(Long id);

}
