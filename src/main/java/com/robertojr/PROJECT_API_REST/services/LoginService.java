package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.repositories.LoginRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoginService {
	@Autowired
	private LoginRepository repository;

	public List<Login> findAll() {
		return repository.findAll();
	}

	public Login findById(Long id) {
		try {
			Optional<Login> opt = repository.findById(id);
			return opt.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	public Login insert(Login Login) {

		return repository.save(Login);

	}

	public Login update(Long id, Login Login) {

		try {

			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}

			Login entity = findById(id);
			Login entityUpdated = updateData(entity, Login);
			return repository.save(entityUpdated);

		} catch (EntityNotFoundException e) {

			String msg = "Failed update caused by: " + e.getMessage();
			throw new ResourceNotFoundException(id, msg);

		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(id);
		}

	}

	public void delete(Long id) {
		try {
			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}
			repository.deleteById(id);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(id);
		}

	}

	public Login updateData(Login entity, Login obj) {

		if (obj.getUserName() != null)
			entity.setUserName(obj.getUserName());
		if (obj.getEmail() != null)
			entity.setEmail(obj.getEmail());
		if (obj.getPassword() != null)
			entity.setPassword(obj.getPassword());
		return entity;

	}

}
