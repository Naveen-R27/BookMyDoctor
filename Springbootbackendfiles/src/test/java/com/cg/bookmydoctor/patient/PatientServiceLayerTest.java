package com.cg.bookmydoctor.patient;

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

import com.cg.bookmydoctor.model.Patient;
import com.cg.bookmydoctor.repository.IPatientRepository;
import com.cg.bookmydoctor.service.IPatientService;
import com.cg.bookmydoctor.service.PatientServiceImplementation;

@ExtendWith(MockitoExtension.class)
class PatientServiceLayerTest {

	@Mock
	private IPatientRepository patientrepository;
	
	IPatientService patientservice;
	
	@BeforeEach
	void initUseCase()
	{
		patientservice = new PatientServiceImplementation(patientrepository);
	}
	
	@Test
	void savedPatientSuccess()
	{
		Patient patient = new Patient();
		patient.setPatientName("manish");
		patient.setMobileNo("983451287");
		patient.setEmail("manish@gmail.com");
		patient.setPassword("abc123");
		patient.setBloodGroup("A+");
		patient.setGender("female");
		patient.setAge(22);
		patient.setAddress("Bangalore");;
		
		when(patientrepository.save(any(Patient.class))).thenReturn(patient);
		
		Patient savedPatient = patientrepository.save(patient);
		assertThat(savedPatient.getPatientName()).isNotNull();
	}
	
	@Test
	void patientexistsindbsuccess()
	{
		Patient patient = new Patient();
		patient.setPatientName("manish");
		patient.setMobileNo("983451287");
		patient.setEmail("manish@gmail.com");
		patient.setPassword("abc123");
		patient.setBloodGroup("A+");
		patient.setGender("female");
		patient.setAge(22);
		patient.setAddress("Bangalore");
		
		List<Patient> patientList = new ArrayList<>();
		patientList.add(patient);
		
		when(patientrepository.findAll()).thenReturn(patientList);
		List<Patient> fetchedpatients = patientservice.viewAllPatient();
		assertThat(fetchedpatients).isNotEmpty();
	}
}

