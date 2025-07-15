package com.robertojr.PROJECT_API_REST.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.repositories.CustomerRepository;
import com.robertojr.PROJECT_API_REST.repositories.RacerRepository;
import com.robertojr.PROJECT_API_REST.repositories.ReserveRepository;
import com.robertojr.PROJECT_API_REST.services.exceptions.DataBaseException;
import com.robertojr.PROJECT_API_REST.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReserveService {
	@Autowired
	private ReserveRepository repository;

	@Autowired
	private RacerRepository racerRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public List<Reserve> findAll() {
		return repository.findAll();
	}

	public Reserve findById(Long id) {
		try {
			Optional<Reserve> opt = repository.findById(id);
			return opt.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	public Reserve insert(Reserve Reserve) {
		if (Reserve.getRacer() != null && Reserve.getRacer().getId() != null) {
			Racer racer = racerRepository.findById(Reserve.getRacer().getId())
					.orElseThrow(() -> new ResourceNotFoundException(Reserve.getRacer().getId(), "Racer Not found!"));
			Reserve.setRacer(racer);
			if (Reserve.getCustomer() != null && Reserve.getCustomer().getId() != null) {
				Customer customer = customerRepository.findById(Reserve.getCustomer().getId()).orElseThrow(
						() -> new ResourceNotFoundException(Reserve.getCustomer().getId(), "Customer Not found!"));
				Reserve.setCustomer(customer);
			}

		}
		return repository.save(Reserve);
	}

	public Reserve update(Long id, Reserve Reserve) {

		try {

			if (!repository.existsById(id)) {
				throw new EntityNotFoundException();
			}

			Reserve entity = findById(id);
			Reserve entityUpdated = updateData(entity, Reserve);
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

	public Reserve updateData(Reserve entity, Reserve obj) {

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
//		
		return entity;
	}
}
