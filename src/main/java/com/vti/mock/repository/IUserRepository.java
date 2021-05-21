package com.vti.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.mock.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{

	public User findByName(String name);
	
	public User findByEmail(String email);
	
	public User findByFacebookId(String facebookId);
}
