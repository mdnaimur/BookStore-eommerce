package com.mnr.bookstore.service;




public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
