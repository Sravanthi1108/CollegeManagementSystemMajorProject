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
@Table(name="professor_table")
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="professor",sequenceName="professor_gen",initialValue=2000)

public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="professor")
	@Column(name="p_id")
	private long pId;
	
	@Column(name="p_name")
	@NotEmpty
	@Size(min=4,message="Name should contain atleast 4 letters in it")
	public String pName;
	
	
	
	@Column(name="email_id",unique=true)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String professorEmailId;
	
	@Column(name="passWord")
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String professorPassword;
	
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

	@Column(name="p_dept")
	@NotEmpty
	@Size(min=5,message="please enter a valid Department")
	public String pDept;

	@Column(name="p_doj")
	@NotEmpty
	@Size(min=5,message="please enter a valid date of joining")
	public String pDoj;

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getProfessorEmailId() {
		return professorEmailId;
	}

	public void setProfessorEmailId(String professorEmailId) {
		this.professorEmailId = professorEmailId;
	}

	public String getProfessorPassword() {
		return professorPassword;
	}

	public void setProfessorPassword(String professorPassword) {
		this.professorPassword = professorPassword;
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

	public String getpDept() {
		return pDept;
	}

	public void setpDept(String pDept) {
		this.pDept = pDept;
	}

	public String getpDoj() {
		return pDoj;
	}

	public void setpDoj(String pDoj) {
		this.pDoj = pDoj;
	}
	

	
}
