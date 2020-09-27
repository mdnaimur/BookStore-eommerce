package com.mnr.bookstore.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserSecurityService.class);

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null) {
			log.info("user {}  not found...");
			throw new UsernameNotFoundException("Username not found!"+username);
		}

		return user;
	}

}
