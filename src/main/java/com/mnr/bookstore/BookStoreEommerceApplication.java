package com.mnr.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.security.Role;
import com.mnr.bookstore.model.security.UserRole;
import com.mnr.bookstore.service.UserService;
import com.mnr.bookstore.utiltiy.SecurityUtility;

@SpringBootApplication
public class BookStoreEommerceApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreEommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		
		user1.setFirstName("Md Naimur");
		user1.setLastName("Rahman");
		user1.setUsername("naimur");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("naimur"));
		user1.setEmail("baby.coder.cse@gmail.com");
		
		Set<UserRole> userRole = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		userRole.add(new UserRole(user1,role));
		userService.createUser(user1,userRole);
	}

}
