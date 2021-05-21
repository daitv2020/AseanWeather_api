package com.vti.mock.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vti.mock.dto.search.CityDTOSearch;
import com.vti.mock.dto.update.CityDTOFormUpdate;
import com.vti.mock.entity.City;
import com.vti.mock.entity.Country;
import com.vti.mock.service.ICityService;
import com.vti.mock.service.ICountryService;

@RestController
@RequestMapping(value = "api/v1/cities")
public class CityController {

	@Autowired
	private ICityService cityService;

	@Autowired
	private ICountryService countryService;

	/*
	 * get list city by filter, search with character
	 */
	@GetMapping()
	public Page<CityDTOSearch> getAllCities(Pageable pageable,
			@RequestParam(name = "search", required = false) String search) {

		Page<City> cities = cityService.getAllCities(pageable, search);

		Page<CityDTOSearch> citiesDto = cities.map(new Function<City, CityDTOSearch>() {

			@Override
			public CityDTOSearch apply(City entity) {
				CityDTOSearch dto = new CityDTOSearch(entity.getName(), entity.getDescription(),
						entity.getCountry().getId(), entity.getImage());
				return dto;
			}
		});
		return citiesDto;
	}

	/*
	 * get info city by id
	 */
	@GetMapping(value = "/{id}")
	public CityDTOSearch getCityById(@PathVariable(name = "id") int id) {
		City city = cityService.getCityById(id);
		if (city == null) {
			return null;
		}
		CityDTOSearch cityDTO = new CityDTOSearch(city.getName(), city.getDescription(), city.getCountry().getId(),
				city.getImage());

		return cityDTO;
	}

	/*
	 * get info city by name
	 */
	@GetMapping(value = "name/{name}")
	public CityDTOSearch getCityByName(@PathVariable(name = "name") String name) {
		City city = cityService.getCityByName(name);
		if (city == null) {
			return null;
		}

		CityDTOSearch cityDTOSearch = new CityDTOSearch(city.getName(), city.getDescription(),
				city.getCountry().getId(), city.getImage());
		return cityDTOSearch;
	}

	/*
	 * create city
	 */
	@PostMapping()
	public void createCity(@RequestBody CityDTOSearch cityDto) {
		City city = new City();
		city.setName(cityDto.getName());
		city.setDescription(cityDto.getDescription());
		city.setImage(cityDto.getImage());
		Country countryid = countryService.getCountryById(cityDto.getCountryID());
		city.setCountry(countryid);

		cityService.createCity(city);
	}

	/*
	 * update city
	 */
	@PutMapping(value = "/{id}")
	public void updateCity(@PathVariable(name = "id") int id, @RequestBody CityDTOFormUpdate cityUpdate) {
		City city = cityService.getCityById(id);
		city.setName(cityUpdate.getName());
		city.setDescription(cityUpdate.getDescription());

		Country countryid = countryService.getCountryById(cityUpdate.getCountryID());
		city.setCountry(countryid);
		city.setImage(cityUpdate.getImage());

		cityService.updateCity(city);
	}

	/*
	 * delete 1 city
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteCity(@PathVariable(name = "id") int id) {
		cityService.deleteCity(id);
	}

	/*
	 * delete multiple city
	 */
	@DeleteMapping()
	public void deleteCities(@RequestParam(name = "ids") List<Integer> ids) {
		cityService.deleteCities(ids);
	}
}
