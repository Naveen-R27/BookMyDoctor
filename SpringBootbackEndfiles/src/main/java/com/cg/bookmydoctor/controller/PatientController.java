package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Patient;
import com.cg.bookmydoctor.service.IPatientService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired(required = true)
	IPatientService ipatientservice;
	
	@GetMapping("/viewPatient/{id}")
	@ExceptionHandler(PatientException.class)
	public Patient viewPatient(@PathVariable("id")Long patientId) throws PatientException
	{
		return ipatientservice.viewPatient(patientId);
	}
	
	@GetMapping("/allPatient")
	public Iterable<Patient> viewAllPatient()
	{
		return ipatientservice.viewAllPatient();
	}

	@PostMapping("/addPatient")
	@ExceptionHandler(PatientException.class)
	public void addPatient(@RequestBody Patient patient)
	{
		ipatientservice.addPatient(patient);
	}
	
	@PutMapping("/updatePatient")
	@ExceptionHandler(PatientException.class)
	public void updatePatient(@RequestBody Patient patient) throws PatientException
	{
		ipatientservice.updatePatient(patient);
	}
	
	@DeleteMapping("/deletePatient/{id}")
	@ExceptionHandler(PatientException.class)
	public void removePatient(@PathVariable("id")Long patientId) throws PatientException
	{
		ipatientservice.removePatient(patientId);
	}
	
	
	/*@PostMapping("/PatientLogin")
	@ExceptionHandler(PatientException.class)
	public Patient loginPatient(@RequestBody Patient patient) throws Exception {
		//System.out.println("**********************************************");
		String email = patient.getEmail();
		String password = patient.getPassword();
		Patient patientObj = null;
		if(email!=null && password!=null ){
			System.out.println("Patient logged in");
			patientObj= ipatientservice.fetchUserByEmailAndPasswordPatient(email,password);
		}else {
			System.out.println("patient not in");
			throw new Exception("Bad Credentials");
		}
		return patientObj;
	}*/

	
	
}