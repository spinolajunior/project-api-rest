package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reserve")
public class Reserve implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer vacancy;
	private Instant dataReserve;
	
	
	@ManyToOne
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne
	private Racer racer;

	public Reserve() {
		
	}

	public Reserve(Long id, Integer vacancy, Instant dataReserve, Customer customer , Racer racer) {
		
		this.id = id;
		this.vacancy = vacancy;
		this.dataReserve = dataReserve;
		this.customer = customer;
		this.racer = racer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Racer getRacer() {
		return racer;
	}

	public void setRacer(Racer racer) {
		this.racer = racer;
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
		Reserve other = (Reserve) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	

}
