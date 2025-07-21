package com.robertojr.PROJECT_API_REST.resources.DTos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.entities.enums.RacerStatus;

public class RacerDTO {

	private Long id;
	private Integer vacanciesTotal;
	private Integer vacanciesAvalaible;
	private Instant time;
	private Double pricePerVacancy;
	private String description;
	private String origin;
	private String destiny;

	private String latitudeO;
	private String longitudeO;
	private String latitudeD;
	private String longitudeD;

	private RacerStatus racerStatus;

	private Long driverId;
	private Set<Long> reservesId = new HashSet<>();

	public RacerDTO() {

	}

	public RacerDTO(Racer racer) {
		this.id = racer.getId();
		this.vacanciesTotal = racer.getVacancies();
		this.vacanciesAvalaible = racer.getAvailableVacancies();
		this.time = racer.getTime();
		this.pricePerVacancy = racer.getPricePerVacancy();
		this.description = racer.getDescription();
		this.origin = racer.getOrigin();
		this.destiny = racer.getDestiny();

		this.latitudeO = racer.getLatitudeO();
		this.longitudeO = racer.getLongitudeO();
		this.latitudeD = racer.getLatitudeD();
		this.longitudeD = racer.getLongitudeD();
		this.racerStatus = racer.getRacerStatus();

		this.driverId = racer.getDriver().getId();

		for (Reserve item : racer.getReserves()) {
			reservesId.add(item.getId());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVacanciesTotal() {
		return vacanciesTotal;
	}

	public void setVacanciesTotal(Integer vacanciesTotal) {
		this.vacanciesTotal = vacanciesTotal;
	}

	public Integer getVacanciesAvalaible() {
		return vacanciesAvalaible;
	}

	public void setVacanciesAvalaible(Integer vacanciesAvalaible) {
		this.vacanciesAvalaible = vacanciesAvalaible;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public RacerStatus getRacerStatus() {
		return racerStatus;
	}

	public void setRacerStatus(RacerStatus racerStatus) {
		this.racerStatus = racerStatus;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Set<Long> getReservesId() {
		return reservesId;
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
		RacerDTO other = (RacerDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
