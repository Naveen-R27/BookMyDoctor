package com.cg.bookmydoctor.admin;

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

import com.cg.bookmydoctor.model.Admin;
import com.cg.bookmydoctor.repository.IAdminRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
		properties = {
				"spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver\r\n",
				"spring.datasource.url=jdbc:mysql://localhost:3306/bookmydoctor?UseSSL=True"
		})
class AdminRepositoryLayerTest {

	@Autowired
	private IAdminRepository adminrepository;
	
	@BeforeEach
	void initUseCase()
	{
		List<Admin> admins = Arrays.asList(new Admin("admin","983412378","admin@gmail.com","abc123"));
		adminrepository.saveAll(admins);
	}
	
	@AfterEach
	public void destroyAll()
	{
		adminrepository.deleteAll();
	}
	
	@Test
	void saveAllSuccess()
	{
		List<Admin> admins = Arrays.asList(
				new Admin("admin","983412378","admin@gmail.com","abc123"),
				new Admin("admin1","892451342","admin1@gmail.com","123abc")
				);
		Iterable<Admin> allAdmin = adminrepository.saveAll(admins);
		
		AtomicInteger validIdFound = new AtomicInteger();
		allAdmin.forEach(admin ->{
			if(admin.getAdminId()>0) {
				validIdFound.getAndIncrement();
			}
		});
		assertThat(validIdFound.intValue()).isEqualTo(2);
	}
	
	@Test
	void findAllSuccess()
	{
		List<Admin> allAdmin = adminrepository.findAll();
		assertThat(allAdmin).isNotEmpty();
	}
	
	@Test
	void findAllFailure()
	{
		List<Admin> allAdmin = adminrepository.findAll();
		assertThat(allAdmin).isEmpty();
	}
}

