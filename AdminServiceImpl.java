package com.example.demo.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

@Service
//@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

	@Autowired
	public AdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) {
//		Admin oldAdmin = this.adminRepository.findByAdminEmailId(admin.getAdminEmailId()).get();
//		System.out.println("1111111111111111"+oldAdmin);
//		if(oldAdmin !=null)
			return adminRepository.save(admin);
//		else
//			throw new ResourceNotFoundException("Admin","present",admin.adminEmailId);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		//System.out.println("Login Successfull");
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword).orElseThrow(()->new ResourceNotFoundException("Admin ", "EmaildId",admin.adminEmailId+"and password "+admin.adminPassword));
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(long adminId) {
		
		return adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
	}

	@Override
	public void deleteAdmin(long adminId) {
		 
		adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		adminRepository.deleteById(adminId);
		
	}

	@Override
	public Admin updateAdmin(Admin admin,long adminId) {
		
		Admin existingUser = adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		
		
		existingUser.setAdminEmailId(admin.getAdminEmailId());
		existingUser.setAdminPassword(admin.getAdminPassword());
		existingUser.setAge(admin.getAge());
		existingUser.setContactNumber(admin.getContactNumber());
		existingUser.setAdminName(admin.getAdminName());
		existingUser.setGender(admin.getGender());
		
		
		adminRepository.save(existingUser);
		
		return existingUser;
		
	}
	

}

