package com.vantory.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.vantory.user.User;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new SpringSecurityAuditorAware();
	}

}
