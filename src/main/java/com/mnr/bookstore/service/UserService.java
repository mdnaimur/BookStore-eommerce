package com.mnr.bookstore.service;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.security.PasswordResetToken;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

}
