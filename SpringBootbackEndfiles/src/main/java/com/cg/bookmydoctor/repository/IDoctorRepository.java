package com.cg.bookmydoctor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.model.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository <Doctor, Long>
{
	
}