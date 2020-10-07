package com.mnr.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.Book;



public interface BookRepository extends CrudRepository<Book,Long>{

}
