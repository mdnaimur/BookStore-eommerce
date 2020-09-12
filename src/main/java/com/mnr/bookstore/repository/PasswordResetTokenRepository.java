package com.mnr.bookstore.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mnr.bookstore.model.User;
import com.mnr.bookstore.model.security.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long>{
	
	PasswordResetToken findByToken(String token);
	PasswordResetToken findByUser(User user);
	Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);
	
	@Modifying
	@Query("delete from PasswordResetToken t where t.expirydate <=?1")
	void deleteAllExpiredSince(Date now);

}
