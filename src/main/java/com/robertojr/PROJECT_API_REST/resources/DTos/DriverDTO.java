package com.robertojr.PROJECT_API_REST.resources.DTos;

import java.util.HashSet;
import java.util.Set;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.entities.enums.AvailableDriver;

public class DriverDTO {
	
	private Long id;
	private String name;
	private String lastName;
	private String phone;
	private Integer ager;
	private String description;
	private String photoProfile;
	
	private String carModel;
	private String plateNumber;
	private Double ratingNumber;
	
	private AvailableDriver available;
	
	private Long credentialId;
	
	private Set<Long> racersId = new HashSet<>();
	
	public DriverDTO() {
		
	}

	public DriverDTO(Driver driver) {
		
		this.id = driver.getId();
		this.name = driver.getName();
		this.lastName = driver.getName();
		this.phone = driver.getPhone();
		this.ager = driver.getAger();
		this.description = driver.getDescription();
		this.photoProfile = driver.getPhotoProfile();
		this.carModel = driver.getCarModel();
		this.plateNumber = driver.getPlateNumber();
		this.ratingNumber = driver.getRatingNumber();
		
		this.available = driver.getAvailable();
		this.credentialId = driver.getCredential().getId();
		
		for(Racer item : driver.getRacers()) {
			racersId.add(item.getId());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAger() {
		return ager;
	}

	public void setAger(Integer ager) {
		this.ager = ager;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoProfile() {
		return photoProfile;
	}

	public void setPhotoProfile(String photoProfile) {
		this.photoProfile = photoProfile;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriverDTO other = (DriverDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
