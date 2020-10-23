package com.mnr.bookstore.service;

import com.mnr.bookstore.model.ShippingAddress;
import com.mnr.bookstore.model.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
