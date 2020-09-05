package com.mnr.bookstore.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.repository.UserRepository;


@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findeByUsername(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("Username not found!");
		}
		
		return user;
	}

}
