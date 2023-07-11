package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Appointment;
import com.cg.bookmydoctor.service.IAppointmentService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired(required = true)
	IAppointmentService iappointmentservice;
	
	@GetMapping("/viewAppointment/{id}")
	@ExceptionHandler(AppointmentException.class)
	public Appointment viewAppointment(@PathVariable("id")Long doctorId) throws AppointmentException
	{
		return iappointmentservice.viewAppointment(doctorId);
	}
	
	@GetMapping("/allAppointment")
	public Iterable<Appointment> viewAllAppointment()
	{
		return iappointmentservice.viewAllAppointment();
	}

	@PostMapping("/addAppointment")
	@ExceptionHandler(AppointmentException.class)
	public void addAppointment(@RequestBody Appointment appointment)
	{
		iappointmentservice.addAppointment(appointment);
	}
	
	@PutMapping("/updateAppointment")
	@ExceptionHandler(AppointmentException.class)
	public void updateAppointment(@RequestBody Appointment appointment) throws AppointmentException
	{
		iappointmentservice.updateAppointment(appointment);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	@ExceptionHandler(AppointmentException.class)
	public void removeAppointment(@PathVariable("id")Long appointmentId) throws AppointmentException
	{
		iappointmentservice.removeAppointment(appointmentId);
	}
}
