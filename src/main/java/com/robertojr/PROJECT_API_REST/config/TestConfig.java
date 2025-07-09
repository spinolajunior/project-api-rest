package com.robertojr.PROJECT_API_REST.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robertojr.PROJECT_API_REST.entities.User;
import com.robertojr.PROJECT_API_REST.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {

		

		
		
		

	}

}
