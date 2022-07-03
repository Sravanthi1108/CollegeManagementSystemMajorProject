package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.model.Professor;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	@Autowired
	public ProfessorRepository professorRepository;
	
	@Override
	public Professor saveProfessor(Professor professor) {
//		Admin oldAdmin = this.adminRepository.findByAdminEmailId(admin.getAdminEmailId()).get();
//		System.out.println("1111111111111111"+oldAdmin);
//		if(oldAdmin !=null)
			return professorRepository.save(professor);
//		else
//			throw new ResourceNotFoundException("Admin","present",admin.adminEmailId);
	}

	@Override
	public Professor loginProfessor(Professor professor) {
		//System.out.println("Login Successfull");
		return this.professorRepository.findByProfessorEmailIdAndProfessorPassword(professor.professorEmailId, professor.professorPassword).orElseThrow(()->new ResourceNotFoundException("Professor ", "EmaildId",professor.professorEmailId+"and password "+professor.professorPassword));
	}

	@Override
	public List<Professor> getAllProfessor() {
		// TODO Auto-generated method stub
		return professorRepository.findAll();
	}

	@Override
	public Professor getProfessorById(long pId) {
		
		return professorRepository.findById(pId).orElseThrow(()->new ResourceNotFoundException("Professor","PId",pId));
	}

	@Override
	public void deleteProfessor(long pId) {
		 
		professorRepository.findById(pId).orElseThrow(()->new ResourceNotFoundException("Professor","PId",pId));
		professorRepository.deleteById(pId);
		
	}

	@Override
	public Professor updateProfessor(Professor professor,long pId) {
		
		Professor existingUser = professorRepository.findById(pId).orElseThrow(()->new ResourceNotFoundException("Professor","PId",pId));
		
		
		existingUser.setProfessorEmailId(professor.getProfessorEmailId());
		existingUser.setProfessorPassword(professor.getProfessorPassword());
		existingUser.setAge(professor.getAge());
		existingUser.setContactNumber(professor.getContactNumber());
		existingUser.setpName(professor.getpName());
		existingUser.setGender(professor.getGender());
		existingUser.setpDoj(professor.getpDoj());
		existingUser.setpDept(professor.getpDept());
		
		
		professorRepository.save(existingUser);
		
		return existingUser;
		
	}

	@Override
	public List<Professor> getAllProfessors() {
		// TODO Auto-generated method stub
		return null;
	}
	

}


	

