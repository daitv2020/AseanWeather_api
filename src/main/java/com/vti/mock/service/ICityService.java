package com.vti.mock.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.mock.entity.City;

public interface ICityService {
	
	public Page<City> getAllCities(Pageable pageable, String search);
	
	public City getCityById(int id);

	public City getCityByName(String name);
	
	public void createCity(City city);

	public void updateCity(City city);
	
	public void deleteCity(int id);
	
	public void deleteCities(List<Integer> ids);
}
