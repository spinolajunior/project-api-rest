package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.repositories.CustomerRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer findById(Long id) {
		try {
			Optional<Customer> opt = repository.findById(id);
			return opt.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	public Customer insert(Customer Customer) {
		return repository.save(Customer);
	}

	public Customer update(Long id, Customer Customer) {

		try {

			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}

			Customer entity = findById(id);
			Customer entityUpdated = updateData(entity, Customer);
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

	public Customer updateData(Customer entity, Customer obj) {

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
