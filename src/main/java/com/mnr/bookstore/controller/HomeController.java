package com.mnr.bookstore.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mnr.bookstore.model.security.PasswordResetToken;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	/*
	 * @RequestMapping("/myAccount") public String myAccount() {
	 * 
	 * return "myAccount"; }
	 */
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "myAccount";
	}

	@RequestMapping("/newUser")
	public String newUser(Model model,Locale locale,@RequestParam("token") String token) {
		//PasswordResetToken passToken = userService.getPasswordResetToken(token);
		
		
		model.addAttribute("classActiveNewAccount", true);
		return "myAccount";
	}

	@RequestMapping("/forgetPassword")
	public String forgetPassword(Model model) {
		
		
		model.addAttribute("classActiveForgetPass", true);
		return "myAccount";
	}

}
