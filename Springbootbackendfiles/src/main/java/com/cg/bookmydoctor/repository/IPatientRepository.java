package com.cg.bookmydoctor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.model.Patient;

@Repository
public interface IPatientRepository extends CrudRepository <Patient, Long>
{
	@Override
	List<Patient> findAll();
	//public  Patient findByEmailAndPasswordPatient(String email, String password);
	
}