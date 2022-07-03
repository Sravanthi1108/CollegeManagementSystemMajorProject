package com.example.demo.model;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="payment_table")
@SequenceGenerator(name="payment",sequenceName="payment_gen",initialValue=7000)
@Data

public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="payment")
	private long paymentId;
	
 
	@Column(name="total_payment")
	private  long totalPayment;
    @Column(name="s_id")
    private long sId;
	
	@Column(name="payment_Date")
	private Date paymentDate;

	@Column(name="payment_status")
	//@NotEmpty
	private String paymentStatus;

 	@Column(name="name_on_card") 
	//@NotEmpty
	//@Size(min=3 , message="name must contain atleast 3 characters")
	private String nameOnCard;

	@Column(name="card_number")
	//@NotEmpty
	//@Size(min=16 , max=16,message="cardNumber must contain 16 digits")
	private String cardNumber;

	@Column(name="exp_year")
	//@NotEmpty
	private String expYear;

	@Column(name="cvv")
	//@NotNull
	private int cvv;
	
	@Column(name="upi")
	 
	private String upi;

	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(long l) {
		this.totalPayment = l;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.util.Date date) {
		this.paymentDate = date;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}
	

	
	

}

