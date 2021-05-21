package com.vti.mock.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.mock.dto.create.UserDTO;
import com.vti.mock.dto.favorite.FavouriteCityDTO;
import com.vti.mock.entity.City;
import com.vti.mock.entity.User;
import com.vti.mock.service.ICityService;
import com.vti.mock.service.IUserService;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICityService cityService;

	/*
	 * get list user by filter, search with character
	 */
	@GetMapping()
	public Page<UserDTO> getAllUsers(Pageable pageable,
			@RequestParam(name = "search", required = false) String search) {

		Page<User> users = userService.getAllUsers(pageable, search);

		Page<UserDTO> usersDto = users.map(new Function<User, UserDTO>() {

			@Override
			public UserDTO apply(User entity) {

				List<FavouriteCityDTO> cityDTOs = new ArrayList<>();

				UserDTO userDTO = new UserDTO(entity.getId(), entity.getName(), entity.getEmail(),
						entity.getFacebookId(), entity.getLoginDate(), cityDTOs);

				for (City city : entity.getFavoriteCities()) {
					cityDTOs.add(new FavouriteCityDTO(city.getId(), city.getName()));
				}

				userDTO.setFavouriteCities(cityDTOs);

				return userDTO;
			}
		});

		return usersDto;
	}

	/*
	 * get info user by id
	 */
	@GetMapping(value = "/{id}")
	public UserDTO getUserById(@PathVariable(name = "id") int id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return null;
		}

		List<FavouriteCityDTO> cityDTOs = new ArrayList<>();

		UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getFacebookId(), user.getLoginDate(), cityDTOs);

		for (City city : user.getFavoriteCities()) {
			cityDTOs.add(new FavouriteCityDTO(city.getId(), city.getName()));
		}

		userDTO.setFavouriteCities(cityDTOs);

		return userDTO;
	}

	/*
	 * get info user by fbId
	 */
	@GetMapping(value = "/fbId")
	public UserDTO getUserByFbId(@RequestParam(name = "fbId", required = true) String fbId) {
		User user = userService.getUserByFbId(fbId);
		if (user == null) {
			return null;
		}

		List<FavouriteCityDTO> cityDTOs = new ArrayList<>();

		UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getFacebookId(),user.getLoginDate(), cityDTOs);

		for (City city : user.getFavoriteCities()) {
			cityDTOs.add(new FavouriteCityDTO(city.getId(), city.getName()));
		}

		userDTO.setFavouriteCities(cityDTOs);

		return userDTO;
	}

	/*
	 * add city to favourite city
	 */
	@PostMapping(value = "/fbId/favourite")
	public String addCityToFavorite(@RequestParam(name = "fbId", required = true) String fbId,
			@RequestBody FavouriteCityDTO favouriteCity) {

		User user = userService.getUserByFbId(fbId);
		
		if (cityService.getCityByName(favouriteCity.getName()) == null) {
			return "City not found !";
		}
		City city = cityService.getCityByName(favouriteCity.getName());

		user.getFavoriteCities().add(city);

		userService.updateUser(user);
		return "Add Successfuly!";
	}
	
	/*
	 * remove city to favourite city
	 */
	@DeleteMapping(value = "/fbId/favourite")
	public String removeCityToFavorite(@RequestParam(name = "fbId", required = true) String fbId,
			@RequestBody FavouriteCityDTO favouriteCity) {

		User user = userService.getUserByFbId(fbId);
		
		if (cityService.getCityByName(favouriteCity.getName()) == null) {
			return "City not found !";
		}
		City city = cityService.getCityByName(favouriteCity.getName());

		user.getFavoriteCities().remove(city);

		userService.updateUser(user);
		return "Remove Successfuly!";
	}

	/*
	 * create user login by fb
	 */
	@PostMapping()
	public String createUser(@RequestBody UserDTO userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setFacebookId(userDto.getFacebookId());
		
		if (userService.getUserByFbId(userDto.getFacebookId()) != null) {
			return "FB ID duplicate!";
		}
		
		userService.createUser(user);
		
		return "Add Successfuly!";
	}

	/*
	 * delete 1 user
	 */
	@DeleteMapping(value = "/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		if (userService.getUserById(id) == null) {
			return "Delete failed!";
		}
		userService.deleteUser(id);
		
		return "Delete Successfuly!";
	}

}
