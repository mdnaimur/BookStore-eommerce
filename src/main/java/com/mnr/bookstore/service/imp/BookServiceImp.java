package com.mnr.bookstore.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnr.bookstore.model.Book;
import com.mnr.bookstore.repository.BookRepository;
import com.mnr.bookstore.service.BookService;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		 return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book findOne(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

}
