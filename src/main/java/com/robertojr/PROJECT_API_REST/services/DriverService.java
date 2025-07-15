package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.repositories.DriverRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DriverService {
	@Autowired
	private DriverRepository repository;

	public List<Driver> findAll() {
		return repository.findAll();
	}

	public Driver findById(Long id) {
		try {
			Optional<Driver> opt = repository.findById(id);
			return opt.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	public Driver insert(Driver Driver) {
		return repository.save(Driver);
	}

	public Driver update(Long id, Driver Driver) {

		try {

			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}

			Driver entity = findById(id);
			Driver entityUpdated = updateData(entity, Driver);
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

	public Driver updateData(Driver entity, Driver obj) {

		if (obj.getName() != null)
			entity.setName(obj.getName());
		if (obj.getLastName() != null)
			entity.setLastName(obj.getLastName());
		if (obj.getPhone() != null)
			entity.setPhone(obj.getPhone());
		if (obj.getAger() != null)
			entity.setAger(obj.getAger());
		if (obj.getDescription() != null)
			entity.setDescription(obj.getDescription());
		if (obj.getPhotoProfile() != null)
			entity.setPhotoProfile(obj.getPhotoProfile());
		if (obj.getCarModel() != null)
			entity.setCarModel(obj.getCarModel());
		if (obj.getPlateNumber() != null)
			entity.setPlateNumber(obj.getPlateNumber());
		if (obj.getAvailable() != null)
			entity.setAvailable(obj.getAvailable().getCode());
		return entity;
	}

}
