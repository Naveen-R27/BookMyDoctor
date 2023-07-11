package com.cg.bookmydoctor.admin;

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

import com.cg.bookmydoctor.controller.AdminController;
import com.cg.bookmydoctor.model.Admin;
import com.cg.bookmydoctor.service.IAdminService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AdminController.class)
@ActiveProfiles("test")
class AdminControllerLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IAdminService adminservice;
	
	private List<Admin> adminList;
	
	@BeforeEach
	void setUp()
	{
		this.adminList = new ArrayList<>();
		this.adminList.add(new Admin("admin","984563724","admin@gmail.com","abc123"));
		this.adminList.add(new Admin("admin1","9374291234","admin1@gmail.com","abc_123"));
		this.adminList.add(new Admin("admin2","8324715938","admin2@gmail.com","123456"));
	}
	
	@AfterEach
	void deleteAll()
	{
		this.adminList.clear();
	}
	
	@Test
	void shouldFetchAllUsers() throws Exception
	{
		given(adminservice.viewAllAdmin()).willReturn(adminList);
		this.mockMvc.perform(get("/admin/viewallAdmin"));
		assertThat(adminList).hasSize(3);
	}
	
	@Test
    void shouldFetchOneAdminById() throws Exception {
        final Long adminId = 1L;
        Admin admin = new Admin("admin","895647324","admin@gmail.com","abc123");

        given(adminservice.viewAdmin(adminId)).willReturn(admin);

        this.mockMvc.perform(get("/admin/viewAdmin/{id}", adminId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(admin.getEmail())))
                .andExpect(jsonPath("$.adminName", is(admin.getAdminName())));
    }


}
