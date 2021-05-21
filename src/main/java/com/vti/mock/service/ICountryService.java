package com.vti.mock.service;

import com.vti.mock.entity.Country;

public interface ICountryService {

	public Country getCountryById(int id);

	public Country getCountryByName(String name);
	
}
