package com.cg.bookmydoctor.service;

import org.springframework.http.ResponseEntity;

import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.model.Appointment;

public interface IAppointmentService {
	
	public Iterable<Appointment> viewAllAppointment();
	public Appointment viewAppointment(Long appointmentId) throws AppointmentException;
	public ResponseEntity<?> addAppointment(Appointment appointment);
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException;
	public String removeAppointment(Long appointmentId) throws AppointmentException;

}