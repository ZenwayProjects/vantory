package com.vantory.verificationToken.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vantory.verificationToken.TokenPurpose;
import com.vantory.verificationToken.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	Optional<VerificationToken> findByEmail(String email);

	Optional<VerificationToken> findByToken(String token);

	Optional<VerificationToken> findByEmailAndPurpose(String email, TokenPurpose purpose);

	Optional<VerificationToken> findByTokenAndPurpose(String token, TokenPurpose purpose);

	void deleteByExpiryDateBefore(LocalDateTime dateTime);

}
