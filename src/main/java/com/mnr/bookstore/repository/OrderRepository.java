package com.mnr.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
