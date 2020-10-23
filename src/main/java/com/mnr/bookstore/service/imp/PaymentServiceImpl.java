package com.mnr.bookstore.service.imp;

import org.springframework.stereotype.Service;

import com.mnr.bookstore.model.Payment;
import com.mnr.bookstore.model.UserPayment;
import com.mnr.bookstore.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
        payment.setType(userPayment.getType());
        payment.setHolderName(userPayment.getHolderName());
        payment.setCardName(userPayment.getCardName());
        payment.setExpiryMonth(userPayment.getExpiryMonth());
        payment.setExpiryYear(userPayment.getExpiryYear());
        payment.setCvc(userPayment.getCvc());
        payment.setCardNumber(userPayment.getCardNumber());

        return payment;
    }
}
