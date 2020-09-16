package com.mnr.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mnr.bookstore.service.imp.UserSecurityService;
import com.mnr.bookstore.utiltiy.SecurityUtility;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	private UserSecurityService userSecurityService;

	private BCryptPasswordEncoder passwordEncoder() {

		return SecurityUtility.passwordEncoder();
	}

	private static final String[] PUBLIC_MATCHERS = { "/css/**", "/js/**", "/images/**", "/", "/myAccount" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest(
		 * ).authenticated().and().formLogin()
		 * .loginPage("/login").permitAll().and().logout().permitAll();
		 */

		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();

		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/**").hasAnyRole(
		 * "USER").and().formLogin()
		 * .loginPage("/login").defaultSuccessUrl("/dashboard",
		 * true).permitAll().and().logout();
		 */

		http.csrf().disable().cors().disable().formLogin().failureUrl("/login?error").defaultSuccessUrl("/").and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/?logout")
				.deleteCookies("remember-me").permitAll().and().rememberMe();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserSecurityService()).passwordEncoder(passwordEncoder());
	}

}
