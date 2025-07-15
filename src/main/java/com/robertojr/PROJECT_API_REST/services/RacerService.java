package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.repositories.DriverRepository;
import com.robertojr.PROJECT_API_REST.repositories.RacerRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RacerService {
	@Autowired
	private RacerRepository repository;

	@Autowired
	private DriverRepository driverRepository;

	public List<Racer> findAll() {
		return repository.findAll();
	}

	public Racer findById(Long id) {
		try {
			Optional<Racer> opt = repository.findById(id);
			return opt.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	public Racer insert(Racer Racer) {
		if (Racer.getDriver() != null && Racer.getDriver().getId() != null) {
			Driver driver = driverRepository.findById(Racer.getDriver().getId())
					.orElseThrow(() -> new ResourceNotFoundException(Racer.getDriver().getId()));
			Racer.setDriver(driver);
		}

		return repository.save(Racer);
	}

	public Racer update(Long id, Racer Racer) {

		try {

			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}

			Racer entity = findById(id);
			Racer entityUpdated = updateData(entity, Racer);
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

	public Racer updateData(Racer entity, Racer obj) {

//		if( obj.getAger() != null) {
//			entity.setAger(obj.getAger());
//		}
//		if (obj.getDescription() != null) {
//			entity.setDescription(obj.getDescription());
//		}
//		if (obj.getName() != null) {
//			entity.setName(obj.getName());
//		}
//		if (obj.getLastName() != null) {
//			entity.setLastName(obj.getLastName());
//		}
//		if (obj.getPhone() != null) {
//			entity.setPhone(obj.getPhone());
//		}
//		if (obj.getPhotoProfile() != null) {
//			entity.setPhotoProfile(obj.getPhotoProfile());
//		}

		return entity;
	}
}
