package com.mnr.bookstore.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnr.bookstore.model.ShoppingCart;
import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.UserBilling;
import com.mnr.bookstore.model.UserPayment;
import com.mnr.bookstore.model.UserShipping;
import com.mnr.bookstore.model.security.PasswordResetToken;
import com.mnr.bookstore.model.security.UserRole;
import com.mnr.bookstore.repository.PasswordResetTokenRepository;
import com.mnr.bookstore.repository.RoleRepository;
import com.mnr.bookstore.repository.UserPaymentRepository;
import com.mnr.bookstore.repository.UserRepository;
import com.mnr.bookstore.repository.UserShippingRepository;
import com.mnr.bookstore.service.UserService;

@Service
public class UserServiceImp implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserShippingRepository userShippingRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserPaymentRepository userPaymentRepository;

	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		// TODO Auto-generated method stub
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {

		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public User createUser(User user, Set<UserRole> userRole) throws Exception {

		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			// throw new Exception("user already exists. Select another");
			log.info("user {} already exists!!Choice another...", user.getUsername());

		} else {
			for (UserRole ur : userRole) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRole);
			
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser(user);
			user.setShoppingCart(shoppingCart);
			user.setUserShippingList(new ArrayList<UserShipping>());
			user.setUserPaymentList(new ArrayList<UserPayment>());

			localUser = userRepository.save(user);

		}
		return localUser;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		userPayment.setUser(user);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		user.getUserPaymentList().add(userPayment);
		save(user);

	}

	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		List<UserPayment> userPaymentList = (List<UserPayment>) userPaymentRepository.findAll();

		for (UserPayment userPayment : userPaymentList) {
			if (userPayment.getId() == userPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			} else {
				userPayment.setDefaultPayment(false);
				userPaymentRepository.save(userPayment);
			}
		}

	}

	@Override
	public void setUserDefaultShipping(Long userShippingId, User user) {

		List<UserShipping> userShippingList = (List<UserShipping>) userShippingRepository.findAll();

		for (UserShipping userShipping : userShippingList) {
			if (userShipping.getId().equals(userShippingId)) {
				userShipping.setUserShippingDefault(true);
				userShippingRepository.save(userShipping);
			} else {
				userShipping.setUserShippingDefault(false);
				userShippingRepository.save(userShipping);
			}
		}

	}

	@Override
	public void updateUserShipping(UserShipping userShipping, User user) {
		userShipping.setUser(user);
		userShipping.setUserShippingDefault(true);
		user.getUserShippingList().add(userShipping);
		save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

}
