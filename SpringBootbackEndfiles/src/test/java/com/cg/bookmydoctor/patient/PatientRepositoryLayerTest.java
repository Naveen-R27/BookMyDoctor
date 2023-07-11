package com.cg.bookmydoctor.patient;

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

import com.cg.bookmydoctor.model.Patient;
import com.cg.bookmydoctor.repository.IPatientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
		properties = {
				"spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver\r\n",
				"spring.datasource.url=jdbc:mysql://localhost:3306/bookmydoctor?UseSSL=True"
		})
class PatientRepositoryLayerTest {

	@Autowired
	private IPatientRepository patientrepository;
	
	@BeforeEach
	void initUseCase()
	{
		List<Patient> patients = Arrays.asList(new Patient("manish","983412378","manish@gmail.com","abc123","A+","male",22,"Bangalore"));
		patientrepository.saveAll(patients);
	}
	
	@AfterEach
	public void destroyAll()
	{
		patientrepository.deleteAll();
	}
	
	@Test
	void saveAllSuccess()
	{
		List<Patient> patients = Arrays.asList(
				new Patient("manish","983412378","manish@gmail.com","abc123","A+","male",22,"Bangalore"),
				new Patient("harini","892451342","harini@gmail.com","123abc","O+","female",27,"Mumbai")
				);
		Iterable<Patient> allPatient = patientrepository.saveAll(patients);
		
		AtomicInteger validIdFound = new AtomicInteger();
		allPatient.forEach(patient ->{
			if(patient.getPatientId()>0) {
				validIdFound.getAndIncrement();
			}
		});
		assertThat(validIdFound.intValue()).isEqualTo(2);
	}
	
	@Test
	void findAllSuccess()
	{
		List<Patient> allPatient = patientrepository.findAll();
		assertThat(allPatient).isNotEmpty();
	}
}

