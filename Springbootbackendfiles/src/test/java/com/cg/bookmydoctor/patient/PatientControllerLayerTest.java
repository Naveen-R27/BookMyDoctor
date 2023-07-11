package com.cg.bookmydoctor.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.bookmydoctor.controller.PatientController;
import com.cg.bookmydoctor.model.Patient;
import com.cg.bookmydoctor.service.IPatientService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PatientController.class)
@ActiveProfiles("test")
class PatientControllerLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IPatientService patientservice;
	
	private List<Patient> patientList;
	
	@BeforeEach
	void setUp()
	{
		this.patientList = new ArrayList<>();
		this.patientList.add(new Patient("harini","984563724","harini@gmail.com","abc123","A+","female",22,"Bangalore"));
		this.patientList.add(new Patient("raju","9374291234","raju@gmail.com","abc_123","O+","male",24,"Mumbai"));
		this.patientList.add(new Patient("ramesh","8324715938","ramesh@gmail.com","123456","A-","male",56,"Delhi"));
	}
	
	@AfterEach
	void deleteAll()
	{
		this.patientList.clear();
	}
	
	@Test
	void shouldFetchAllPatient() throws Exception
	{
		given(patientservice.viewAllPatient()).willReturn(patientList);
		this.mockMvc.perform(get("/patient/viewallPatient"));
		assertThat(patientList).hasSize(3);
	}
	
	@Test
    void shouldFetchOnePatientById() throws Exception {
        final Long patientId = 1L;
        Patient patient = new Patient("harini","984563724","harini@gmail.com","abc123","A+","female",22,"Bangalore");

        given(patientservice.viewPatient(patientId)).willReturn(patient);

        this.mockMvc.perform(get("/patient/viewPatient/{id}", patientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(patient.getEmail())))
                .andExpect(jsonPath("$.patientName", is(patient.getPatientName())));
    }
}

