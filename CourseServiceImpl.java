package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
//import com.example.demo.service.courseNotValidException;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	public CourseRepository courseRepository;
	
	
	
	@Autowired
	public StudentService studentService;



	@Override
	public Course addCourse(long sId, Course course) {
		// TODO Auto-generated method stub
		Student student=studentService.getStudentById(sId);
		course.setStudent(student);
		return courseRepository.save(course);
		
	}



	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}



	@Override
	public Course getCourseById(long courseId) {
		// TODO Auto-generated method stub
		return courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("course","courseId",courseId));
	}
	
	
	
	
}