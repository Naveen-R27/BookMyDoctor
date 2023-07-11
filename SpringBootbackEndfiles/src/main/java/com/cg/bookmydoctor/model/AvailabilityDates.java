package com.cg.bookmydoctor.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Calendar;


@Entity
@Table(name="availability_dates")
public class AvailabilityDates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long availabilityId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Doctor doctor;
	
	@Temporal(TemporalType.DATE)
	private Calendar fromDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar toDate;

	public long getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(long availabilityId) {
		this.availabilityId = availabilityId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}
}
