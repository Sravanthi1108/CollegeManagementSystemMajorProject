package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_table")
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="student",sequenceName="student_gen",initialValue=500)
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="student")
	@Column(name="s_id")
	private long sId;
	
	@Column(name="s_name")
	@NotEmpty
	@Size(min=4,message="Name should contain atleast 4 letters in it")
	public String sName;
	
	
	
	@Column(name="email_id",unique=true)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String studentEmailId;
	
	@Column(name="passWord")
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String studentPassword;
	
	@Column(name="age")
	@NotNull
	public int age;
	
	@Column(name="gender")
	@NotEmpty
	@Size(min=4,message="please enter gender as male , female , not disclosed")
	public String gender;
	
	@Column(name="contact_number")
	@NotEmpty
	@Size(min=5,message="please enter a valid contact number")
	public String contactNumber;

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	


}