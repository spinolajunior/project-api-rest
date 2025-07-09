package com.robertojr.PROJECT_API_REST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository repository;

	public List<Login> findAll() {
		return repository.findAll();
	}
}
