package com.mnr.bookstore.service;

import java.util.Set;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.UserBilling;
import com.mnr.bookstore.model.UserPayment;
import com.mnr.bookstore.model.UserShipping;
import com.mnr.bookstore.model.security.PasswordResetToken;
import com.mnr.bookstore.model.security.UserRole;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);

	User findByEmail(String email);

	User save(User user);

	User createUser(User user, Set<UserRole> userRole) throws Exception;

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setUserDefaultPayment(Long userPaymentId, User user);

	void setUserDefaultShipping(Long defaultShippingId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	User findById(Long id);

	

}
