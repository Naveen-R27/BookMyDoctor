package com.cg.bookmydoctor.service;

import org.springframework.http.ResponseEntity;

import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.model.Doctor;

public interface IDoctorService {
	
	public Iterable<Doctor> viewAllDoctor();
	public Doctor viewDoctor(Long doctorId) throws DoctorException;
	public ResponseEntity<?> addDoctor(Doctor doctor);
	public Doctor updateDoctor(Doctor doctor) throws DoctorException;
	public String removeDoctor(Long doctorId) throws DoctorException;

}