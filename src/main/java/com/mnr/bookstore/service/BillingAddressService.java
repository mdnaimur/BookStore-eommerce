package com.mnr.bookstore.service;

import com.mnr.bookstore.model.BillingAddress;
import com.mnr.bookstore.model.UserBilling;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
