package com.mnr.bookstore.service;

import java.util.List;

import com.mnr.bookstore.model.Book;
import com.mnr.bookstore.model.CartItem;
import com.mnr.bookstore.model.Order;
import com.mnr.bookstore.model.ShoppingCart;
import com.mnr.bookstore.model.User;

public interface CartItemService {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addBookToCartItem(Book book, User user, int qty);

    CartItem findById(Long id);

    void removeCartItem(CartItem cartItem);

    CartItem save(CartItem cartItem);

    List<CartItem> findByOrder(Order order);
}
