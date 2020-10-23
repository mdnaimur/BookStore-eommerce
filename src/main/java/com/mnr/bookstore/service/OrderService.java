package com.mnr.bookstore.service;

import com.mnr.bookstore.model.BillingAddress;
import com.mnr.bookstore.model.Order;
import com.mnr.bookstore.model.Payment;
import com.mnr.bookstore.model.ShippingAddress;
import com.mnr.bookstore.model.ShoppingCart;
import com.mnr.bookstore.model.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMehod, User user);

	Order findOne(Long id);
}
