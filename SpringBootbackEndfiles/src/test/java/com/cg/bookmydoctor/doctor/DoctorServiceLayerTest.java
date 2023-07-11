package com.cg.bookmydoctor.doctor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.bookmydoctor.model.Doctor;
import com.cg.bookmydoctor.repository.IDoctorRepository;
import com.cg.bookmydoctor.service.DoctorServiceImplementation;
import com.cg.bookmydoctor.service.IDoctorService;

@ExtendWith(MockitoExtension.class)
class DoctorServiceLayerTest {

	@Mock
	private IDoctorRepository doctorrepository;
	
	IDoctorService doctorservice;
	
	@BeforeEach
	void initUseCase()
	{
		doctorservice = new DoctorServiceImplementation(doctorrepository);
	}
	
	@Test
	void savedDoctorSuccess()
	{
		Doctor doctor = new Doctor();
		doctor.setDoctorName("manasa");
		doctor.setSpeciality("dentist");
		doctor.setLocation("bangalore");
		doctor.setHospitalName("Appolo");
		doctor.setMobileNo("9832401923");
		doctor.setEmail("manasa@gmail.com");
		doctor.setPassword("abc123");
		doctor.setChargedPerVisit(1000);
		
		when(doctorrepository.save(any(Doctor.class))).thenReturn(doctor);
		
		Doctor savedDoctor = doctorrepository.save(doctor);
		assertThat(savedDoctor.getDoctorName()).isNotNull();
	}
	
	@Test
	void adminexistsindbsuccess()
	{
		Doctor doctor = new Doctor();
		doctor.setDoctorName("manasa");
		doctor.setSpeciality("dentist");
		doctor.setLocation("bangalore");
		doctor.setHospitalName("Appolo");
		doctor.setMobileNo("9832401923");
		doctor.setEmail("manasa@gmail.com");
		doctor.setPassword("abc123");
		doctor.setChargedPerVisit(1000);
		
		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(doctor);
		
		when(doctorrepository.findAll()).thenReturn(doctorList);
		List<Doctor> fetcheddoctors = (List<Doctor>) doctorservice.viewAllDoctor();
		assertThat(fetcheddoctors).isNotEmpty();
	}
}

