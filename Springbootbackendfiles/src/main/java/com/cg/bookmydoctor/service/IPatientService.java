package com.cg.bookmydoctor.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.model.Patient;

public interface IPatientService {
	
	public List<Patient> viewAllPatient();
	public Patient viewPatient(Long patientId) throws PatientException;
	public ResponseEntity<?> addPatient(Patient patient);
	public Patient updatePatient(Patient patient) throws PatientException;
	public String removePatient(Long patientId) throws PatientException;
	//public Patient fetchUserByEmailAndPasswordPatient(String email, String password) throws PatientException;

}