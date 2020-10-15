package com.mnr.bookstore.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.BookToCartItem;
import com.mnr.bookstore.model.CartItem;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
