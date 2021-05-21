package com.vti.mock.dto.create;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.mock.dto.favorite.FavouriteCityDTO;

public class UserDTO {

	private int id;

	private String name;

	private String email;

	private String facebookId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime loginDate;

	private List<FavouriteCityDTO> favouriteCities;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public List<FavouriteCityDTO> getFavouriteCities() {
		return favouriteCities;
	}

	public void setFavouriteCities(List<FavouriteCityDTO> favouriteCities) {
		this.favouriteCities = favouriteCities;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}
	
	public UserDTO(int id, String name, String email, String facebookId, List<FavouriteCityDTO> favouriteCities) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.facebookId = facebookId;
		this.favouriteCities = favouriteCities;
	}

	public UserDTO(int id, String name, String email, String facebookId, LocalDateTime loginDate,List<FavouriteCityDTO> favouriteCities) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.facebookId = facebookId;
		this.favouriteCities = favouriteCities;
		this.loginDate = loginDate;
	}
	
	public UserDTO() {
	}

}
