package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Doctor;
import com.cg.bookmydoctor.service.IDoctorService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired(required = true)
	IDoctorService idoctorservice;
	
	@GetMapping("/viewDoctor/{id}")
	@ExceptionHandler(DoctorException.class)
	public Doctor viewDoctor(@PathVariable("id")Long doctorId) throws DoctorException
	{
		return idoctorservice.viewDoctor(doctorId);
	}
	
	@GetMapping("/allDoctor")
	public Iterable<Doctor> viewAllDoctor()
	{
		return idoctorservice.viewAllDoctor();
	}

	@PostMapping("/addDoctor")
	@ExceptionHandler(DoctorException.class)
	public void addDoctor(@RequestBody Doctor doctor)
	{
		idoctorservice.addDoctor(doctor);
	}
	
	@PutMapping("/updateDoctor")
	@ExceptionHandler(DoctorException.class)
	public void updateDoctor(@RequestBody Doctor doctor) throws DoctorException
	{
		idoctorservice.updateDoctor(doctor);
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	@ExceptionHandler(DoctorException.class)
	public void removeDoctor(@PathVariable("id")Long doctorId) throws DoctorException
	{
		idoctorservice.removeDoctor(doctorId);
	}
}