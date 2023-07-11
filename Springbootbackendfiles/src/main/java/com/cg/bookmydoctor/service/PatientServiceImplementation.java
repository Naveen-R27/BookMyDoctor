package com.cg.bookmydoctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Patient;
import com.cg.bookmydoctor.repository.IPatientRepository;

@Service
public class PatientServiceImplementation implements IPatientService {
	
	@Autowired
	IPatientRepository ipatientrepository;

	public PatientServiceImplementation(IPatientRepository patientrepository) {
		this.ipatientrepository = patientrepository;
	}

	//view all patient
	@Override
	public List<Patient> viewAllPatient() {
		return ipatientrepository.findAll();
	}

	//view patient by id
	@Override
	public Patient viewPatient(Long patientId) throws PatientException {
		Optional<Patient> findById = ipatientrepository.findById(patientId);
		if (findById.isPresent()) {
			return findById.get();
		}
		
		else
		{
			throw new PatientException("Patient with Id:"+patientId+" not exists");
		}
	}

	//add patient
	@Override
	public ResponseEntity<?> addPatient(Patient patient) {
		Optional<Patient> findById = ipatientrepository.findById(patient.getPatientId());
		try {
			if (!findById.isPresent()) {
				ipatientrepository.save(patient);
				return new ResponseEntity<>(patient,HttpStatus.OK);
			}
			else {
				throw new PatientException("Patient with Id:"+patient.getPatientId()+" already present");
			}
		}
		catch(PatientException e)
		{
			return new ResponseEntity<>(patient,HttpStatus.NOT_FOUND);
		}
	}
	
	//modify patient
	@Override
	public Patient updatePatient(Patient patient) throws PatientException {
		Optional<Patient> findById = ipatientrepository.findById(patient.getPatientId());
		if(findById.isPresent()) {
			ipatientrepository.save(patient);
		}
		else
			throw new PatientException("Patient with Id: "+patient.getPatientId()+" not exists");
		return patient;
	}

	@Override
	public String removePatient(Long patientId) throws PatientException {
		Optional<Patient> findById = ipatientrepository.findById(patientId);
		if(findById.isPresent()) {
			ipatientrepository.deleteById(patientId);
			return "Patient removed";
		}
		else
		{
			throw new PatientException("Patient with Id: "+patientId+" does not exist");
		}
	}
	
	
	/*@Override
	public Patient fetchUserByEmailAndPasswordPatient(String email, String password){ //Patient -login
		//System.out.println("patientLogin-repo");
		return ipatientrepository.findByEmailAndPasswordPatient(email,password);
	}*/
	
	
}
