package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;


import com.example.demo.model.Professor;

public interface ProfessorService {
	Professor saveProfessor(@Valid Professor professor);

	Professor loginProfessor(Professor professor);

	List<Professor> getAllProfessor();

	Professor getProfessorById(long pId);

	Professor updateProfessor(Professor professor, long pId);

	void deleteProfessor(long PId);

	List<Professor> getAllProfessors();

	

	


}
