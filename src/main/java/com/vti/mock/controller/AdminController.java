package com.vti.mock.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.mock.entity.Admin;
import com.vti.mock.service.IAdminService;

@RestController
@RequestMapping(value = "api/v1/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	// login Admin
	
	@GetMapping()
	public Page<Admin> getallADmin(Pageable pageable) {
		
		Page<Admin> admin = adminService.getAll(pageable);
		
		Page<Admin> adminDto = admin.map(new Function<Admin, Admin>() {

			@Override
			public Admin apply(Admin t) {
				Admin aply = new Admin(
						t.getId(),
						t.getEmail()
						);
				return aply;
			}
		});
		return adminDto;
	}
}

