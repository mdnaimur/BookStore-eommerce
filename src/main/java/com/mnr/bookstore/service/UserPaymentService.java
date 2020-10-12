package com.mnr.bookstore.service;

import com.mnr.bookstore.model.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
