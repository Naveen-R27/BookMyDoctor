package com.cg.bookmydoctor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.model.Appointment;

@Repository
public interface IAppointmentRepository extends CrudRepository <Appointment, Long>
{
	
}