package com.cg.bookmydoctor.admin;

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

import com.cg.bookmydoctor.model.Admin;
import com.cg.bookmydoctor.repository.IAdminRepository;
import com.cg.bookmydoctor.service.AdminServiceImplementation;
import com.cg.bookmydoctor.service.IAdminService;

@ExtendWith(MockitoExtension.class)
class AdminServiceLayerTest {

	@Mock
	private IAdminRepository adminrepository;
	
	IAdminService adminservice;
	
	@BeforeEach
	void initUseCase()
	{
		adminservice = new AdminServiceImplementation(adminrepository);
	}
	
	@Test
	void savedAdminSuccess()
	{
		Admin admin = new Admin();
		admin.setAdminName("admin");
		admin.setContactNumber("9832401923");
		admin.setEmail("admin@gmail.com");
		admin.setPassword("abc123");
		
		when(adminrepository.save(any(Admin.class))).thenReturn(admin);
		
		Admin savedAdmin = adminrepository.save(admin);
		assertThat(savedAdmin.getAdminName()).isNotNull();
	}
	
	@Test
	void adminexistsindbsuccess()
	{
		Admin admin = new Admin();
		admin.setAdminName("admin");
		admin.setContactNumber("9832401923");
		admin.setEmail("admin@gmail.com");
		admin.setPassword("abc123");
		
		List<Admin> adminList = new ArrayList<>();
		adminList.add(admin);
		
		when(adminrepository.findAll()).thenReturn(adminList);
		List<Admin> fetchedadmins = adminservice.viewAllAdmin();
		assertThat(fetchedadmins).isNotEmpty();
	}
}

