package com.cg.bookmydoctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Admin;
import com.cg.bookmydoctor.repository.IAdminRepository;

@Service
public class AdminServiceImplementation implements IAdminService {
	
	@Autowired
	IAdminRepository iadminrepository;

	public AdminServiceImplementation(IAdminRepository adminrepository) {
		this.iadminrepository = adminrepository;
	}

	//view all admins
	@Override
	public List<Admin> viewAllAdmin() {
		return iadminrepository.findAll();
	}

	//view admin by id
	@Override
	public Admin viewAdmin(Long adminId) throws AdminException {
		Optional<Admin> findById = iadminrepository.findById(adminId);
		if (findById.isPresent()) {
			return findById.get();
		}
		
		else
		{
			throw new AdminException("Admin with Id:"+adminId+" not exists");
		}
	}

	//add admin
	@Override
	public ResponseEntity<?> addAdmin(Admin admin) {
		Optional<Admin> findById = iadminrepository.findById(admin.getAdminId());
		try {
			if (!findById.isPresent()) {
				iadminrepository.save(admin);
				return new ResponseEntity<>(admin,HttpStatus.OK);
			}
			else {
				throw new AdminException("Admin with Id:"+admin.getAdminId()+" already present");
			}
		}
		catch(AdminException e)
		{
			return new ResponseEntity<>(admin,HttpStatus.NOT_FOUND);
		}
	}
	
	//modify admin
	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		Optional<Admin> findById = iadminrepository.findById(admin.getAdminId());
		if(findById.isPresent()) {
			iadminrepository.save(admin);
		}
		else
			throw new AdminException("Admin with Id: "+admin.getAdminId()+" not exists");
		return admin;
	}

	@Override
	public String removeAdmin(Long adminId) throws AdminException {
		Optional<Admin> findById = iadminrepository.findById(adminId);
		if(findById.isPresent()) {
			iadminrepository.deleteById(adminId);
			return "Admin removed";
		}
		else
		{
			throw new AdminException("Admin with Id: "+adminId+" does not exist");
		}
	}

}
