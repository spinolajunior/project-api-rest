package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_customer")
@DiscriminatorValue("CUSTOMER")
public class Customer extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Set<Reserve> reserves = new HashSet<>();
	
	public Customer() {
		
	}

	public Customer(Long id, String name, String lastName, String phone, Integer ager, String description,
			String photoProfile, Login credential) {
		super(id, name, lastName, phone, ager, description, photoProfile, credential);
	}

	public Set<Reserve> getReserves() {
		return reserves;
	}
	
	
	
	
	

}
