package com.vti.mock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.mock.entity.City;
import com.vti.mock.repository.ICityRepository;
import com.vti.mock.specification.CitySpecification;

@Service
@Transactional
public class CityService implements ICityService {

	@Autowired
	private ICityRepository repository;

	/**
	 * get all and filter, search by character
	 */
	@SuppressWarnings("unused")
	@Override
	public Page<City> getAllCities(Pageable pageable, String search) {

		CitySpecification searchSpecification = new CitySpecification("name", "Like", search);

		Specification<City> where = null;

		if (!StringUtils.isEmpty(search)) {
			if (where == null) {
				where = searchSpecification;
			} else {
				where = where.and(searchSpecification);
			}
		}

		return repository.findAll(where, pageable);
	}

	/**
	 * get info by id
	 */
	@Override
	public City getCityById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public City getCityByName(String name) {
		return repository.findByName(name);
	}

	/**
	 * create city
	 */
	@Override
	public void createCity(City city) {
		repository.save(city);
	}

	/**
	 * update info city
	 */
	@Override
	public void updateCity(City city) {
		repository.save(city);
	}

	/**
	 * delete 1 city
	 */
	@Override
	public void deleteCity(int id) {
		repository.deleteById(id);
	}

	/**
	 * delete nhieu city
	 */
	@Override
	public void deleteCities(List<Integer> ids) {
		repository.deleteByIds(ids);
	}

}
