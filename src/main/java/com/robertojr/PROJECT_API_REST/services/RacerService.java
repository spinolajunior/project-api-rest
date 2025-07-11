package com.robertojr.PROJECT_API_REST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.repositories.RacerRepository;

@Service
public class RacerService {
	@Autowired
	private RacerRepository repository;

	public List<Racer> findAll() {
		return repository.findAll();
	}
}
