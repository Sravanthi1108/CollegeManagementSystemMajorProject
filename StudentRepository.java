package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	Optional<Student> findByStudentEmailIdAndStudentPassword(String emailId,String password);
	//Optional<Student> findBysEmailId(String sEmailId);



}
