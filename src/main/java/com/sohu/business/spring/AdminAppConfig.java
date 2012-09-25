package com.sohu.business.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sohu.business.service.impl.AccountPassportService;
import com.sohu.business.service.impl.AccountPassportServiceImpl;
import com.sohu.business.service.impl.UserService;
import com.sohu.business.service.impl.UserServiceImpl;

@Configuration

public class AdminAppConfig {
	@Bean
	public AccountPassportService  accountPassportService(){
		return new AccountPassportServiceImpl();
	}
	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}
}
