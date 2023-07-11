package com.cg.bookmydoctor.doctor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import com.cg.bookmydoctor.model.Doctor;
import com.cg.bookmydoctor.repository.IDoctorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
		properties = {
				"spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver\r\n",
				"spring.datasource.url=jdbc:mysql://localhost:3306/bookmydoctor?UseSSL=True"
		})
class DoctorRepositoryLayerTest {

	@Autowired
	private IDoctorRepository doctorrepository;
	
	@BeforeEach
	void initUseCase()
	{
		List<Doctor> doctors = Arrays.asList(new Doctor("manasa","dentist","bangalore","Appolo","984563724","manasa@gmail.com","abc123",1000.00));
		doctorrepository.saveAll(doctors);
	}
	
	@AfterEach
	public void destroyAll()
	{
		doctorrepository.deleteAll();
	}
	
	@Test
	void saveAllSuccess()
	{
		List<Doctor> doctors = Arrays.asList(
				new Doctor("manasa","dentist","bangalore","Appolo","984563724","manasa@gmail.com","abc123",1000.00),
				new Doctor("vinay","pediatrician","mumbai","Appolo","9374291234","vinay@gmail.com","abc_123",1500.00)
				);
		Iterable<Doctor> allDoctor = doctorrepository.saveAll(doctors);
		
		AtomicInteger validIdFound = new AtomicInteger();
		allDoctor.forEach(doctor ->{
			if(doctor.getDoctorId()>0) {
				validIdFound.getAndIncrement();
			}
		});
		assertThat(validIdFound.intValue()).isEqualTo(2);
	}
	
	@Test
	void findAllSuccess()
	{
		List<Doctor> allDoctor = (List<Doctor>) doctorrepository.findAll();
		assertThat(allDoctor).isNotEmpty();
	}
	
	@Test
	void findAllFailure()
	{
		List<Doctor> allDoctor = (List<Doctor>) doctorrepository.findAll();
		assertThat(allDoctor).isEmpty();
	}
}
