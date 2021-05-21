package com.vti.mock.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.mock.entity.Admin;

public interface IAdminService extends UserDetailsService{

	public Admin findAdminByEmail(String email);
	
	public Page<Admin> getAll(Pageable pageable);

}
