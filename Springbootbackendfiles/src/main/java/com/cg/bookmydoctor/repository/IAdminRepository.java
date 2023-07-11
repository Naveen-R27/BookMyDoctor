package com.cg.bookmydoctor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.model.Admin;

@Repository
public interface IAdminRepository extends CrudRepository <Admin, Long>
{	
	@Override
	List<Admin> findAll();
}