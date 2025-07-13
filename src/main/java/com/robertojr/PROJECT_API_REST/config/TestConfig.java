package com.robertojr.PROJECT_API_REST.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.repositories.CustomerRepository;
import com.robertojr.PROJECT_API_REST.repositories.DriverRepository;
import com.robertojr.PROJECT_API_REST.repositories.LoginRepository;
import com.robertojr.PROJECT_API_REST.repositories.RacerRepository;
import com.robertojr.PROJECT_API_REST.repositories.ReserveRepository;
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
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RacerRepository racerRepository;
	
	@Autowired
	ReserveRepository reserveRepository;
	
	@Override
	public void run(String... args) throws Exception {

		
		Login login1 = new Login(
			    null,
			    "spinola147",
			    "120777Ce'",
			    "juniorspinola16@gmail.com");
		
		Login login2 = new Login(
			    null,
			    "vitoriaCosta",
			    "12345678",
			    "vitoria@gmail.com");
		
		
		Driver driver = new Driver(null,
				"Roberto",
				"Júnior", 
				"75983717345",
				24,
				"Motorista Qualificado",
				"Endereço Url da foto", login1, "Grand Siena","OZH7B20", 0);
		
		
		Customer customer = new Customer(null,
				"Vitoria",
				"Costa",
				"7598371745",
				22,
				"Cliente linda",
				"URL photo",login2);
		
		
		
		
		
		Racer racer1 = new Racer(null,
				"São Bernardo",
				"Nazare",
				4,
				Instant.now(),
				10.0,
				"-12.7100",
				"-38.9650",
				"-12.7390",
				"-38.9640",
				"São Bernardo a Nazare as 7Hrs",1,driver);
		
		Reserve reserve = new Reserve(null,5,Instant.now(),customer,racer1);
		
		driverRepository.save(driver);
		customerRepository.save(customer);
		racerRepository.save(racer1);
		reserveRepository.save(reserve);
		
		
		
		
		
		
		
		
		

	}

}
