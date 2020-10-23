package com.mnr.bookstore.service;

import com.mnr.bookstore.model.Payment;
import com.mnr.bookstore.model.UserPayment;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
