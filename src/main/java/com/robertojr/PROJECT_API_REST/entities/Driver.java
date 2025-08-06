package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.robertojr.PROJECT_API_REST.entities.enums.AvailableDriver;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_driver")
@DiscriminatorValue("DRIVER")
public class Driver extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String carModel;
	private String plateNumber;
	private Double ratingNumber = 0.0;
	private AvailableDriver available;
	
	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonIgnore
	private Set<Racer> racers = new HashSet<>();

	
	public Driver() {

	}

	public Driver(Long id, String name, String lastName, String phone, Integer ager, String description,
			String photoProfile, Login credentials, String carModel, String plateNumber, String available) {
		super(id, name, lastName, phone, ager, description, photoProfile, credentials);
		this.carModel = carModel;
		this.plateNumber = plateNumber;
		
		this.available = AvailableDriver.valueOfCode(Integer.parseInt(available));
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

	public void setAvailable( int code) {
		this.available = AvailableDriver.valueOfCode(code);
	}

	public Set<Racer> getRacers() {
		return racers;
	}

	
	
	

}
