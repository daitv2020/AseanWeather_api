package com.vti.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.mock.entity.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {

	public Admin findByEmail(String email);
}
