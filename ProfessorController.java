package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Professor;
import com.example.demo.service.AdminService;
import com.example.demo.service.ProfessorService;

@RestController

@RequestMapping("/api/professor")
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/register")
	public ResponseEntity<Professor> saveProfessor(@Valid @RequestBody Professor professor){
		System.out.println("Professor Registration Succesfull "+professor);
		return new ResponseEntity<Professor>(professorService.saveProfessor(professor),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Professor> loginProfessor(@RequestBody Professor professor){
		return new ResponseEntity<Professor>(professorService.loginProfessor(professor),HttpStatus.OK);
	}
	//get all professor details
	@GetMapping
	public List<Professor> getAllProfessor(){
		return professorService.getAllProfessor();
	}
	//get professor by id
	@GetMapping("{pId}")
	public ResponseEntity<Professor> getProfessorById(@PathVariable("pId") long pId){
		
		return new ResponseEntity<Professor>(professorService.getProfessorById(pId),HttpStatus.OK);
	}
	
	//updating professor details
	@PutMapping("{pId}")
	public ResponseEntity<Professor> updateProfessor(@PathVariable("pId") long pId, @RequestBody Professor professor) {
	
		return new ResponseEntity<Professor>(professorService.updateProfessor(professor,pId),HttpStatus.OK);
	}
	//delete by id
	@DeleteMapping("{pId}")
	public ResponseEntity<Boolean> deleteProfessor(@PathVariable("pId") long pId){
		professorService.deleteProfessor(pId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		
	}
	
	

}


