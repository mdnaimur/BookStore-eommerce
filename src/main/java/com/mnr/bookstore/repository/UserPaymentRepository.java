package com.mnr.bookstore.repository;


import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
