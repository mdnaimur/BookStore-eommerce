package com.mnr.bookstore.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.security.PasswordResetToken;
import com.mnr.bookstore.repository.PasswordResetTokenRepository;
import com.mnr.bookstore.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		// TODO Auto-generated method stub
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		
		final PasswordResetToken myToken = new PasswordResetToken(token,user);
		passwordResetTokenRepository.save(myToken);
	}

}
