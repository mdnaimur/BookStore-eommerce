package com.mnr.bookstore.service;

import com.mnr.bookstore.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);
}
