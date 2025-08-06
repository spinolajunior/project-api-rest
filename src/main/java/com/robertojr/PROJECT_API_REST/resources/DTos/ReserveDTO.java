package com.robertojr.PROJECT_API_REST.resources.DTos;

import java.io.Serializable;
import java.time.Instant;

import com.robertojr.PROJECT_API_REST.entities.Reserve;

public class ReserveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer vacancy;
	private Instant dataReserve;
	private Long customerId;
	private Long racerId;

	public ReserveDTO() {

	}

	public ReserveDTO(Reserve reserve) {
		this.id = reserve.getId();
		this.vacancy = reserve.getVacancy();
		this.dataReserve = reserve.getDataReserve();
		customerId = reserve.getCustomer().getId();
		racerId = reserve.getRacer().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVacancy() {
		return vacancy;
	}

	public void setVacancy(Integer vacancy) {
		this.vacancy = vacancy;
	}

	public Instant getDataReserve() {
		return dataReserve;
	}

	public void setDataReserve(Instant dataReserve) {
		this.dataReserve = dataReserve;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getRacerId() {
		return racerId;
	}

	public void setRacerId(Long racerId) {
		this.racerId = racerId;
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
		ReserveDTO other = (ReserveDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
