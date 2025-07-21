package com.robertojr.PROJECT_API_REST.resources.DTos;

import com.robertojr.PROJECT_API_REST.entities.Customer;

public class CustomerDTO {
	
	private Long id;
	private String name;
	private String lastName;
	private String phone;
	private Integer ager;
	private String description;
	private String photoProfile;
	private Long credentialID;
	
	public CustomerDTO() {
		
	}
	
	
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.lastName = customer.getLastName();
		this.phone = customer.getPhone();
		this.ager = customer.getAger();
		this.description = customer.getDescription();
		this.photoProfile = customer.getPhotoProfile();
		credentialID = customer.getCredential().getId();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAger() {
		return ager;
	}
	public void setAger(Integer ager) {
		this.ager = ager;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoProfile() {
		return photoProfile;
	}
	public void setPhotoProfile(String photoProfile) {
		this.photoProfile = photoProfile;
	}
	public Long getCredentialID() {
		return credentialID;
	}
	public void setCredentialID(Long credentialID) {
		this.credentialID = credentialID;
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
		CustomerDTO other = (CustomerDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
