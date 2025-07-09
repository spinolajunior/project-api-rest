package com.robertojr.PROJECT_API_REST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.repositories.DriverRepository;

@Service
public class DriverService {
	@Autowired
	private DriverRepository repository;

	public List<Driver> findAll() {
		return repository.findAll();
	}
}
