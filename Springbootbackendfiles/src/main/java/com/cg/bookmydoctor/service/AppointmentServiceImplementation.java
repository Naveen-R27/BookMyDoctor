package com.cg.bookmydoctor.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Appointment;
import com.cg.bookmydoctor.repository.IAppointmentRepository;

@Service
public class AppointmentServiceImplementation implements IAppointmentService {
	
	@Autowired
	IAppointmentRepository iappointmentrepository;

	//view all appointments
	@Override
	public Iterable<Appointment> viewAllAppointment() {
		return iappointmentrepository.findAll();
	}

	//view appointment by id
	@Override
	public Appointment viewAppointment(Long appointmentId) throws AppointmentException {
		Optional<Appointment> findById = iappointmentrepository.findById(appointmentId);
		if (findById.isPresent()) {
			return findById.get();
		}
		
		else
		{
			throw new AppointmentException("Appointment with Id:"+appointmentId+" not exists");
		}
	}

	//add appointment
	@Override
	public ResponseEntity<?> addAppointment(Appointment appointment) {
		Optional<Appointment> findById = iappointmentrepository.findById(appointment.getAppointmentId());
		try {
			if (!findById.isPresent()) {
				iappointmentrepository.save(appointment);
				return new ResponseEntity<>(appointment,HttpStatus.OK);
			}
			else {
				throw new AppointmentException("Appointment with Id:"+appointment.getAppointmentId()+" already present");
			}
		}
		catch(AppointmentException e)
		{
			return new ResponseEntity<>(appointment,HttpStatus.NOT_FOUND);
		}
	}
	
	//modify appointment
	@Override
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
		Optional<Appointment> findById = iappointmentrepository.findById(appointment.getAppointmentId());
		if(findById.isPresent()) {
			iappointmentrepository.save(appointment);
		}
		else
			throw new AppointmentException("Appointment with Id: "+appointment.getAppointmentId()+" not exists");
		return appointment;
	}

	@Override
	public String removeAppointment(Long appointmentId) throws AppointmentException {
		Optional<Appointment> findById = iappointmentrepository.findById(appointmentId);
		if(findById.isPresent()) {
			iappointmentrepository.deleteById(appointmentId);
			return "Appointment removed";
		}
		else
		{
			throw new AppointmentException("Appointment with Id: "+appointmentId+" does not exist");
		}
	}
}