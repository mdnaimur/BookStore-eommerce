package com.mnr.bookstore.repository;
import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
