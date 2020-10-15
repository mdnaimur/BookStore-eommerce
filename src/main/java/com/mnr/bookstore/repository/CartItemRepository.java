package com.mnr.bookstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.mnr.bookstore.model.CartItem;
import com.mnr.bookstore.model.Order;
import com.mnr.bookstore.model.ShoppingCart;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    List<CartItem> findByOrder(Order order);
}
