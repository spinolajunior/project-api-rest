package com.robertojr.PROJECT_API_REST.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.repositories.DriverRepository;
import com.robertojr.PROJECT_API_REST.repositories.LoginRepository;
import com.robertojr.PROJECT_API_REST.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LoginRepository loginRepository;	
	
	@Autowired
	DriverRepository driverRepository;
	
	@Override
	public void run(String... args) throws Exception {

		
		Login login = new Login(
			    null,
			    "spinola147",
			    "120777Ce'",
			    "juniorspinol");
		
		
		Driver driver = new Driver(null,
				"Roberto",
				"Júnior", 
				"75983717345",
				24,
				"Motorista Qualificado",
				"Endereço Url da foto", login, "Grand Siena","OZH7B20", 0);
		
		driver.getCredential().setUserObj(driver);
		
		
		
		
		driverRepository.save(driver);
		
		

	}

}
