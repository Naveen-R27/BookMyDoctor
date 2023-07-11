package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Admin;
import com.cg.bookmydoctor.service.IAdminService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired(required = true)
	IAdminService iadminservice;
	
	@GetMapping("/viewAdmin/{id}")
	@ExceptionHandler(AdminException.class)
	public Admin viewAdmin(@PathVariable("id")Long adminId) throws AdminException
	{
		return iadminservice.viewAdmin(adminId);
	}
	
	@GetMapping("/allAdmin")
	public Iterable<Admin> viewAllAdmin()
	{
		return iadminservice.viewAllAdmin();
	}

	@PostMapping("/addAdmin")
	@ExceptionHandler(AdminException.class)
	public void addAdmin(@RequestBody Admin admin)
	{
		iadminservice.addAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	@ExceptionHandler(AdminException.class)
	public void updateAdmin(@RequestBody Admin admin) throws AdminException
	{
		iadminservice.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	@ExceptionHandler(AdminException.class)
	public void removeAdmin(@PathVariable("id")Long adminId) throws AdminException
	{
		iadminservice.removeAdmin(adminId);
	}
}
