package com.vti.mock.dto.favorite;

public class FavouriteCityDTO {
	private int id;

	private String name;

	public FavouriteCityDTO() {

	}

	public FavouriteCityDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public FavouriteCityDTO(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}