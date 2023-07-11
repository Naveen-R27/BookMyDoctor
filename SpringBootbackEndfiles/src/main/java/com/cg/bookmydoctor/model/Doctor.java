package com.cg.bookmydoctor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long doctorId;
	
	public String doctorName;
	
	public String speciality;
	
	public String location;
	
	public String hospitalName;
	
	public String mobileNo;
	
	public String email;
	
	private String password;
	
	private double chargedPerVisit;

	public Doctor(String doctorName, String speciality, String location, String hospitalName, String mobileNo,
			String email, String password, double chargedPerVisit) {
		super();
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.hospitalName = hospitalName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.chargedPerVisit = chargedPerVisit;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getChargedPerVisit() {
		return chargedPerVisit;
	}

	public void setChargedPerVisit(double chargedPerVisit) {
		this.chargedPerVisit = chargedPerVisit;
	}
}
