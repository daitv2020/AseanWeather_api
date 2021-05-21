package com.vti.mock.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * mapping class voi table trong database
 */
@Entity
@Table(name = "City")
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * mapping column
	 */
	@Column(name = "CityID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CityName", length = 100, nullable = false, unique = true)
	private String name;

	@Column(name = "Description", length = 50, nullable = false, unique = true)
	private String description;

	/**
	 * foreignKey countryID -> join with Country table
	 */
	@ManyToOne
	@JoinColumn(name = "CountryID")
	private Country country;

	@Column(name = "Image", length = 50, nullable = false, unique = true)
	private String image;

	/**
	 * join with city table -> Favourite city
	 */
	@ManyToMany(mappedBy = "favoriteCities")
	List<User> listUser;

	/**
	 * Constructor for class Admin
	 */
	public City() {
		
	}

	public City(int id, String name) {
		this.id = id;
		this.name = name;
	}


	/**
	 * getter va setter
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public List<User> getListUser() {
		return listUser;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
