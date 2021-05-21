package com.vti.mock.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.mock.entity.City;

public interface ICityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City>{

	/**
	 * search tên thành phố
	 */
	public City findByName(String name);
	
	
	/**
	 * xóa nhiều city
	 */
	@Modifying
	@Transactional
	@Query("delete from City where id in (:ids)")  
	public void deleteByIds(@Param("ids") List<Integer> ids);
	
}
