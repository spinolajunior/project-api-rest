package com.robertojr.PROJECT_API_REST.resources.DTos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.entities.enums.AvailableDriver;

public class DriverDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	private String carModel;
	private String plateNumber;
	private Double ratingNumber;
	
	private AvailableDriver available;
	
	private Long credentialId;
	
	private Set<Long> racersId = new HashSet<>();
	
	public DriverDTO() {
		
	}

	public DriverDTO(Driver driver) {
		
		setId( driver.getId());
		setName(driver.getName());
		setLastName(driver.getLastName());
		setPhone(driver.getPhone());
		setAger(driver.getAger());
		setDescription(driver.getDescription());
		setPhotoProfile(driver.getPhotoProfile());
		
		this.carModel = driver.getCarModel();
		this.plateNumber = driver.getPlateNumber();
		this.ratingNumber = driver.getRatingNumber();
		
		this.available = driver.getAvailable();
		this.credentialId = driver.getCredential().getId();
		
		for(Racer item : driver.getRacers()) {
			racersId.add(item.getId());
		}
	}

	
	

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Double getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(Double ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	public AvailableDriver getAvailable() {
		return available;
	}
	

	public Set<Long> getRacersId() {
		return racersId;
	}

	

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public void setAvailable(AvailableDriver available) {
		this.available = available;
	}

	
	
	

}
