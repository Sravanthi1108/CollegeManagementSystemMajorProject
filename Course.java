package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.Data;

@Entity
@Table(name="course_table")
//@Data
@SequenceGenerator( name="course",sequenceName="course_gen",initialValue=5000)
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="course")
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_fee")
	private long courseFee;
	
	public long getCourseId() {
		return courseId;
	}
	
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() { 
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public long getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(long courseFee) {
		this.courseFee = courseFee;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@ManyToOne( cascade=CascadeType.MERGE) 
	@JoinColumn(name="s_id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private Student student;
	 
}
	

	
	

	





	






	



	

	


	



	


	
	


	