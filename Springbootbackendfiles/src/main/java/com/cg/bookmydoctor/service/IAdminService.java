package com.cg.bookmydoctor.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.model.Admin;

public interface IAdminService {
	
	public List<Admin> viewAllAdmin();
	public Admin viewAdmin(Long adminId) throws AdminException;
	public ResponseEntity<?> addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin) throws AdminException;
	public String removeAdmin(Long adminId) throws AdminException;

}