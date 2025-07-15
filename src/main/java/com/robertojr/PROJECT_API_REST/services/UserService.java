package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.entities.User;
import com.robertojr.PROJECT_API_REST.repositories.LoginRepository;
import com.robertojr.PROJECT_API_REST.repositories.UserRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	@Autowired
	private LoginRepository loginRepository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		try {
			Optional<User> opt = repository.findById(id);
			return opt.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	public User insert(User user) {

		try {

			if (user.getCredential() != null && user.getCredential().getId() != null) {
				Login credential = loginRepository.findById(user.getCredential().getId())
						.orElseThrow(() -> new ResourceNotFoundException(user.getId()));

				user.setCredential(credential);

			}

			return repository.save(user);

		} catch (RuntimeException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

	}

	public User update(Long id, User user) {

		try {

			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}

			User entity = findById(id);
			User entityUpdated = updateData(entity, user);
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

	public User updateData(User entity, User obj) {

		if (obj.getAger() != null) {
			entity.setAger(obj.getAger());
		}
		if (obj.getDescription() != null) {
			entity.setDescription(obj.getDescription());
		}
		if (obj.getName() != null) {
			entity.setName(obj.getName());
		}
		if (obj.getLastName() != null) {
			entity.setLastName(obj.getLastName());
		}
		if (obj.getPhone() != null) {
			entity.setPhone(obj.getPhone());
		}
		if (obj.getPhotoProfile() != null) {
			entity.setPhotoProfile(obj.getPhotoProfile());
		}

		return entity;
	}

}
