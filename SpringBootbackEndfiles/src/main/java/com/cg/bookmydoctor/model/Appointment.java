package com.cg.bookmydoctor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Entity
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointmentId;
	
	
	@Temporal(TemporalType.DATE)
	private Calendar appointmentDate;
	
	private long doctorId;
	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	
	private String doctorName;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
	public Appointment()
	{
		
	}

	public Appointment(long doctorId, Calendar appointmentDate, String doctorName) {
		super();
		
		this.doctorId=doctorId;
		this.doctorName=doctorName;
		this.appointmentDate = appointmentDate;
		
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	
	public Calendar getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Calendar appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	

	
}
