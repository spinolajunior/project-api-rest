package com.robertojr.PROJECT_API_REST.resources.DTos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.entities.Reserve;

public class CustomerDTO extends UserDTO {

	private List<ReserveDTO> reserves = new ArrayList<>();

	public CustomerDTO() {

	}

	public CustomerDTO(Customer customer) {
		setId(customer.getId());
		setName(customer.getName());
		setLastName(customer.getLastName());
		setPhone(customer.getPhone());
		setAger(customer.getAger());
		setDescription(customer.getDescription());
		setPhotoProfile(customer.getPhotoProfile());
		setCredentialId(customer.getCredential().getId());
		setReserves(customer.getReserves());
		
	}

	public List<ReserveDTO> getReserves() {
		return reserves;
	}

	public void setReserves(Set<Reserve> reserves) {
		for (Reserve item : reserves) {
			if (item != null) {
				this.reserves.add(new ReserveDTO(item));
			}

		}
	}

	

}
