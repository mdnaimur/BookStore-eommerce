package com.mnr.bookstore.service;

import com.mnr.bookstore.model.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
