package com.robertojr.PROJECT_API_REST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.repositories.ReserveRepository;

@Service
public class ReserveService {
	@Autowired
	private ReserveRepository repository;

	public List<Reserve> findAll() {
		return repository.findAll();
	}
}
