package com.robertojr.PROJECT_API_REST.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Historico;
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.repositories.CustomerRepository;
import com.robertojr.PROJECT_API_REST.repositories.DriverRepository;
import com.robertojr.PROJECT_API_REST.repositories.HistoricoRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

@Service
public class HistoricoService {

	@Autowired
	HistoricoRepository repository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	DriverRepository driverRepository;

	public Set<Historico> findByCustomer(Long id) {
		
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id, "Customer not Found"));

		Set<Historico> historicoCustomer = new HashSet<>();

		for (Reserve item : customer.getReserves()) {
			historicoCustomer.add(new Historico().historicoCustomer(item));
		}

		return historicoCustomer;
		
	}

	public Set<Historico> findByDriver(Long id) {

		Driver driver = driverRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id, "Driver not Found"));

		Set<Historico> historicoDriver = new HashSet<>();

		for (Racer item : driver.getRacers()) {
			historicoDriver.add(new Historico().historicoDriver(item));
		}

		return historicoDriver;
	}

}
