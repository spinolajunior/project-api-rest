package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.robertojr.PROJECT_API_REST.entities.enums.RacerStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Racer")
public class Racer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String origin;
	private String destiny;
	private Integer vacancyFull;
	private Integer vacancyAvailable;
	private Instant Time;
	private Double pricePerVacancy;
	private String latitude;
	private String longitude;
	private String description;
	private RacerStatus racerStatus;
	
	@ManyToOne
	private Driver driver ;
	
	@OneToMany(mappedBy = "racer",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Reserve> reserves = new HashSet<>();
	
	public Racer() {
		
	}

	public Racer(Long id, String origin, String destiny, Integer vacancyFull, Integer vacancyAvailable, Instant time,
			Double pricePerVacancy, String latitude, String longitude, String description, int racerStatus,Driver driver) {
		
		this.id = id;
		this.origin = origin;
		this.destiny = destiny;
		this.vacancyFull = vacancyFull;
		this.vacancyAvailable = vacancyAvailable;
		Time = time;
		this.pricePerVacancy = pricePerVacancy;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.racerStatus = RacerStatus.valueOfCode(racerStatus);
		this.driver = driver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public Integer getVacancyFull() {
		return vacancyFull;
	}

	public void setVacancyFull(Integer vacancyFull) {
		this.vacancyFull = vacancyFull;
	}

	public Integer getVacancyAvailable() {
		return vacancyAvailable;
	}

	public void setVacancyAvailable(Integer vacancyAvailable) {
		this.vacancyAvailable = vacancyAvailable;
	}

	public Instant getTime() {
		return Time;
	}

	public void setTime(Instant time) {
		Time = time;
	}

	public Double getPricePerVacancy() {
		return pricePerVacancy;
	}

	public void setPricePerVacancy(Double pricePerVacancy) {
		this.pricePerVacancy = pricePerVacancy;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RacerStatus getRacerStatus() {
		return racerStatus;
	}

	public void setRacerStatus(RacerStatus racerStatus) {
		this.racerStatus = racerStatus;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
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
		Racer other = (Racer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	

}
