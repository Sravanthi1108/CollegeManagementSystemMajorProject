package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long>{
	Optional<Professor> findByProfessorEmailIdAndProfessorPassword(String emailId,String password);
	Optional<Professor> findByProfessorEmailId(String professorEmailId);

}
