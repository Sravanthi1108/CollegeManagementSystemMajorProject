package com.example.demo.serviceimpl;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Professor;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	public StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
//		Admin oldAdmin = this.adminRepository.findByAdminEmailId(admin.getAdminEmailId()).get();
//		System.out.println("1111111111111111"+oldAdmin);
//		if(oldAdmin !=null)
			return studentRepository.save(student);
//		else
//			throw new ResourceNotFoundException("Admin","present",admin.adminEmailId);
	}

	@Override
	public Student loginStudent(Student student) {
		//System.out.println("Login Successfull");
		return this.studentRepository.findByStudentEmailIdAndStudentPassword(student.studentEmailId, student.studentPassword).orElseThrow(()->new ResourceNotFoundException("Student ", "EmaildId",student.studentEmailId+"and password "+student.studentPassword));
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long sId) {
		
		return studentRepository.findById(sId).orElseThrow(()->new ResourceNotFoundException("Student","sId",sId));
	}

	@Override
	public void deleteStudent(long sId) {
		 
		studentRepository.findById(sId).orElseThrow(()->new ResourceNotFoundException("Student","sId",sId));
		studentRepository.deleteById(sId);
	}

	@Override
	public Student updateStudent(Student student,long sId) {
		
		Student existingUser = studentRepository.findById(sId).orElseThrow(()->new ResourceNotFoundException("Student","sId",sId));
		
		
		existingUser.setStudentEmailId(student.getStudentEmailId());
		existingUser.setStudentPassword(student.getStudentPassword());
		existingUser.setAge(student.getAge());
		existingUser.setContactNumber(student.getContactNumber());
		existingUser.setsName(student.getsName());
		existingUser.setGender(student.getGender());
		existingUser.setsId(student.getsId());
		
		
		
		studentRepository.save(existingUser);
		
		return existingUser;
		
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}
	

}


	


	




