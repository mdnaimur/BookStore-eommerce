package com.mnr.bookstore.utiltiy;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.mnr.bookstore.model.User;

@Component
public class MailConstructor {
	
	@Autowired
	private Environment evn;
	
	public SimpleMailMessage constructResetTokenEmail(String contextPath,Locale locale,String token, User user,String password)
	{
		
		String url = contextPath + "/newUser?token="+token;
		String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is :\n"+password;
		
		SimpleMailMessage email = new SimpleMailMessage();
		//email.setFrom("noreply@baeldung.com");
		
		email.setFrom(evn.getProperty("support.email"));
		email.setTo(user.getEmail());
		email.setSubject("Welcome!! \n Let's e-BookStore - New User");
		email.setText(url+message);
		
		System.out.println("This is form mailer class:"+user.getEmail());
		return email;
		
	}

	
}
