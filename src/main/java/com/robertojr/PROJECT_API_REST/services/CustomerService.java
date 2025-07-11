package com.robertojr.PROJECT_API_REST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}
}
