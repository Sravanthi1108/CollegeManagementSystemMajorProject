package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Admin;

public interface AdminService {

	Admin saveAdmin(@Valid Admin admin);

	Admin loginAdmin(Admin admin);

	List<Admin> getAllAdmins();

	Admin getAdminById(long adminId);

	Admin updateAdmin(Admin admin, long adminId);

	void deleteAdmin(long adminId);

}
