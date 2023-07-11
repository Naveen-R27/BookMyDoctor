package com.cg.bookmydoctor.doctor;

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

import com.cg.bookmydoctor.controller.DoctorController;
import com.cg.bookmydoctor.model.Doctor;
import com.cg.bookmydoctor.service.IDoctorService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DoctorController.class)
@ActiveProfiles("test")
class DoctorControllerLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IDoctorService doctorservice;
	
	private List<Doctor> doctorList;
	
	@BeforeEach
	void setUp()
	{
		this.doctorList = new ArrayList<>();
		this.doctorList.add(new Doctor("manasa","dentist","bangalore","Appolo","984563724","manasa@gmail.com","abc123",1000.00));
		this.doctorList.add(new Doctor("vinay","pediatrician","mumbai","Appolo","9374291234","vinay@gmail.com","abc_123",1500.00));
	}
	
	@AfterEach
	void deleteAll()
	{
		this.doctorList.clear();
	}
	
	@Test
	void shouldFetchAllDoctors() throws Exception
	{
		given(doctorservice.viewAllDoctor()).willReturn(doctorList);
		this.mockMvc.perform(get("/doctor/viewallDoctor"));
		assertThat(doctorList).hasSize(2);
	}
	
	@Test
    void shouldFetchOneDoctorById() throws Exception {
        final Long doctorId = 1L;
        Doctor doctor = new Doctor("manasa","dentist","bangalore","Appolo","984563724","manasa@gmail.com","abc123",1000.00);

        given(doctorservice.viewDoctor(doctorId)).willReturn(doctor);

        this.mockMvc.perform(get("/doctor/viewDoctor/{id}", doctorId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(doctor.getEmail())))
                .andExpect(jsonPath("$.doctorName", is(doctor.getDoctorName())));
    }
}
