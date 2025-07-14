package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.User;
import com.robertojr.PROJECT_API_REST.repositories.UserRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> opt = repository.findById(id);
		return opt.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public User update(Long id, User user) {
	
		try {
			User entity = findById(id);
			User entityUpdated = updateData(entity, user);
			return repository.save(entityUpdated);
		}catch (Exception e) {
			String msg = "Failed update caused by: "+e.getMessage();
			throw new ResourceNotFoundException(id,msg);
		}
		
	}
	
	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}
			
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(id);
		}
			
	}
	
	
	
	
	
	public User updateData(User entity,User obj ) {
		
		entity.setAger(obj.getAger());
		entity.setDescription(obj.getDescription());
		entity.setName(obj.getName());
		entity.setLastName(obj.getLastName());
		entity.setPhone(obj.getPhone());
		entity.setPhotoProfile(obj.getPhotoProfile());
		
		
		return entity;
	}

	
}
