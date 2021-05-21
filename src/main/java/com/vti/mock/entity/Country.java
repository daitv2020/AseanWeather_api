package com.vti.mock.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * mapping class voi table trong database
 */
@Entity
@Table(name = "Country")
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * mapping column
	 */
	@Column(name = "CountryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CountryName", length = 250, nullable = false, unique = true)
	private String name;
	
	@Column(name = "Description", nullable = false)
	private String description;
	
	@Column(name = "Image", length = 256)
	private String image;
	
	/**
	 * join City class
	 */
	@OneToMany(mappedBy = "country")
	private List<City> cities;
	
	public Country() {
		
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + "]";
	}
	
}
