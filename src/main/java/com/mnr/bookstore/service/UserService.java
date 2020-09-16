package com.mnr.bookstore.service;

import java.util.Set;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.security.PasswordResetToken;
import com.mnr.bookstore.model.security.UserRole;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);
    User findByEmail(String email);

	User createUser(User user, Set<UserRole> userRole) throws Exception;
}
