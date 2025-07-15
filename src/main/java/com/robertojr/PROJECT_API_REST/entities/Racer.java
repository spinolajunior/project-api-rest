package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	private Integer vacancies;
	private Instant time;
	private Double pricePerVacancy;
	private String description;
	private String origin;
	private String destiny;
	
	//origin
	private String latitudeO;
	private String longitudeO;
	
	//destiny
	private String latitudeD;
	private String longitudeD;
	
	
	

	
	private RacerStatus racerStatus;
	
	@ManyToOne
	private Driver driver ;
	
	
	@OneToMany(mappedBy = "racer",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Set<Reserve> reserves = new HashSet<>();
	
	public Racer() {
		
	}

	public Racer(Long id, String origin, String destiny, Integer vacancies, Instant time,
			Double pricePerVacancy, String latitudeO, String longitudeO, String latitudeD,String longitudeD, String description, int racerStatus,Driver driver) {
		
		this.id = id;
		this.origin = origin;
		this.destiny = destiny;
		this.vacancies = vacancies;
		this.time = time;
		this.pricePerVacancy = pricePerVacancy;
		this.latitudeO = latitudeO;
		this.longitudeO = longitudeO;
		this.latitudeD = latitudeD;
		this.longitudeD = longitudeD;
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

	public Integer getVacancies() {
		return vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public Double getPricePerVacancy() {
		return pricePerVacancy;
	}

	public void setPricePerVacancy(Double pricePerVacancy) {
		this.pricePerVacancy = pricePerVacancy;
	}

	public String getLatitudeO() {
		return latitudeO;
	}

	public void setLatitudeO(String latitudeO) {
		this.latitudeO = latitudeO;
	}

	public String getLongitudeO() {
		return longitudeO;
	}

	public void setLongitudeO(String longitudeO) {
		this.longitudeO = longitudeO;
	}

	public String getLatitudeD() {
		return latitudeD;
	}

	public void setLatitudeD(String latitudeD) {
		this.latitudeD = latitudeD;
	}

	public String getLongitudeD() {
		return longitudeD;
	}

	public void setLongitudeD(String longitudeD) {
		this.longitudeD = longitudeD;
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
	
	
	public Set<Reserve> getReserves() {
		return reserves;
	}

	@JsonProperty("availableVacancies")
	public int getAvailableVacancies() {
		int availableVacancies = vacancies;
		if(vacancies > 0) {
			for(Reserve item : reserves) {
				if(availableVacancies >= item.getVacancy()) {
					availableVacancies -= item.getVacancy();
				}
				
			}
		}
		return availableVacancies;
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
