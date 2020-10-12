package com.mnr.bookstore.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnr.bookstore.model.UserShipping;
import com.mnr.bookstore.repository.UserShippingRepository;
import com.mnr.bookstore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService {

    @Autowired
    private UserShippingRepository userShippingRepository;

    public UserShipping findById(Long id) {
        return userShippingRepository.findById(id).get();
    }

    public void removeById(Long id) {
        userShippingRepository.deleteById(id);
    }
}
