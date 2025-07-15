package com.robertojr.PROJECT_API_REST.resources.DTos;

import java.util.Objects;

import com.robertojr.PROJECT_API_REST.entities.User;

public class UserDTO {

	private Long id;
	private String name;
	private String lastName;
	private String phone;
	private Integer ager;
	private String description;
	private String photoProfile;

	public UserDTO(){
		
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.lastName = user.getLastName();
		this.phone = user.getPhone();
		this.ager = user.getAger();
		this.description = user.getDescription();
		this.photoProfile = user.getPhotoProfile();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
