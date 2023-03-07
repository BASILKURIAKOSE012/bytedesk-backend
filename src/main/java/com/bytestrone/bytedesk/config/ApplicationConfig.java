package com.bytestrone.bytedesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.bytestrone.bytedesk.repository.UserRepo;

@Configuration
public class ApplicationConfig {

	private final UserRepo userRepo;
	@Bean
	public UserDetailsService userDetailsService() {
		return userName->userRepo.findByUserName(userName)
				.orElseThrow(()->new UsernameNotFoundException("User not found"));
	}
	public ApplicationConfig(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

}
