package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Professor;
import com.example.demo.model.Student;

public interface StudentService {
	Student saveStudent(@Valid Student student);

	Student loginStudent(Student student);

	List<Student> getAllStudent();

	Student getStudentById(long sId);

	Student updateStudent(Student student, long sId);

	void deleteStudent(long sId);
	List<Student> getAllStudents();

	

}
