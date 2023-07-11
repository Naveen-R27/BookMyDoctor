package com.cg.bookmydoctor.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Doctor;
import com.cg.bookmydoctor.repository.IDoctorRepository;

@Service
public class DoctorServiceImplementation implements IDoctorService {
	
	@Autowired
	IDoctorRepository idoctorrepository;

	public DoctorServiceImplementation(IDoctorRepository doctorrepository) {
		this.idoctorrepository = doctorrepository;
	}

	//view all doctors
	@Override
	public Iterable<Doctor> viewAllDoctor() {
		return idoctorrepository.findAll();
	}

	//view doctor by id
	@Override
	public Doctor viewDoctor(Long doctorId) throws DoctorException {
		Optional<Doctor> findById = idoctorrepository.findById(doctorId);
		if (findById.isPresent()) {
			return findById.get();
		}
		
		else
		{
			throw new DoctorException("Doctor with Id:"+doctorId+" not exists");
		}
	}

	//add doctors
	@Override
	public ResponseEntity<?> addDoctor(Doctor doctor) {

		Optional<Doctor> findById = idoctorrepository.findById(doctor.getDoctorId());
		try {
			if (!findById.isPresent()) {
				idoctorrepository.save(doctor);
				return new ResponseEntity<>(doctor,HttpStatus.OK);
			}
			else {
				throw new DoctorException("Doctor with Id:"+doctor.getDoctorId()+" already present");
			}
		}
		catch(DoctorException e)
		{
			return new ResponseEntity<>(doctor,HttpStatus.NOT_FOUND);
		}
	}
	
	//modify doctor
	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorException {
		Optional<Doctor> findById = idoctorrepository.findById(doctor.getDoctorId());
		if(findById.isPresent()) {
			idoctorrepository.save(doctor);
		}
		else
			throw new DoctorException("Doctor with Id: "+doctor.getDoctorId()+" not exists");
		return doctor;
	}

	@Override
	public String removeDoctor(Long doctorId) throws DoctorException {

		Optional<Doctor> findById = idoctorrepository.findById(doctorId);
		if(findById.isPresent()) {
			idoctorrepository.deleteById(doctorId);
			return "Doctor removed";
		}
		else
		{
			throw new DoctorException("Doctor with Id: "+doctorId+" does not exist");
		}
	}
}