package com.mnr.bookstore.utiltiy;

import java.util.Locale;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import com.mnr.bookstore.model.Order;
import com.mnr.bookstore.model.User;

@Component
public class MailConstructor {

	@Autowired
	private Environment evn;

	@Autowired
	private TemplateEngine templateEngine;

	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user,
			String password) {

		String url = contextPath + "/newUser?token=" + token;
		String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is :\n"
				+ password;

		SimpleMailMessage email = new SimpleMailMessage();
		// email.setFrom("noreply@baeldung.com");

		email.setFrom(evn.getProperty("support.email"));
		email.setTo(user.getEmail());
		email.setSubject("Welcome!! \n Let's e-BookStore - New User");
		email.setText(url + message);

		System.out.println("This is form mailer class:" + user.getEmail());
		return email;

	}

	public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order, Locale locale) {
		org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
		context.setVariable("order", order);
		context.setVariable("user", user);
		context.setVariable("cartItemList", order.getCartItemList());
		String text = templateEngine.process("orderConfirmationEmailTemplate", context);

		return new MimeMessagePreparator() {
			@Override
			public void prepare(javax.mail.internet.MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setText(user.getEmail());
				email.setSubject("Order Confirmation - " + order.getId());
				email.setText(text, true);
				email.setFrom(new InternetAddress("ray.deng83@gmail.com"));
			}
		};
	}

}
