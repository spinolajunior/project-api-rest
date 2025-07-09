package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_driver")
public class Driver extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String carModel;
	private String plateNumber;
	private Double ratingNumber;
	private Boolean available;
	
	public Driver() {
		
	}

	public Driver(Long id, String name, String lastName, String phone, Integer ager, String description,
			String photoProfile, Login credentials, String carModel, String plateNumber, Double ratingNumber,
			Boolean available) {
		super(id, name, lastName, phone, ager, description, photoProfile, credentials);
		this.carModel = carModel;
		this.plateNumber = plateNumber;
		this.ratingNumber = ratingNumber;
		this.available = available;
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

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
	
	
	

}
