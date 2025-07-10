package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;

import com.robertojr.PROJECT_API_REST.entities.enums.Available;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_driver")
public class Driver extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String carModel;
	private String plateNumber;
	private Double ratingNumber;
	private Available available;

	public Driver() {

	}

	public Driver(Long id, String name, String lastName, String phone, Integer ager, String description,
			String photoProfile, Login credentials, String carModel, String plateNumber, int available) {
		super(id, name, lastName, phone, ager, description, photoProfile, credentials);
		this.carModel = carModel;
		this.plateNumber = plateNumber;
		this.ratingNumber = 0.0;
		this.available = Available.valueOfCode(available);
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

	public Available getAvailable() {
		return available;
	}

	public void setAvailable( int code) {
		this.available = Available.valueOfCode(code);
	}

}
