package com.vti.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.mock.entity.Admin;
import com.vti.mock.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService{
	@Autowired
	private IAdminRepository adminRepository;
	// Phân quyền khi đăng nhập của Admin
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(email);

		String role = null;
		if (admin != null) {
			role = "Admin";
		} else {
			throw new UsernameNotFoundException(email);
		}

		return new org.springframework.security.core.userdetails.User(
				admin.getEmail(), 
				admin.getPassword(),
				AuthorityUtils.createAuthorityList(role));
	}

	@Override
	public Admin findAdminByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	@Override
	public Page<Admin> getAll(Pageable pageable) {
		return adminRepository.findAll(pageable);
	}
}
