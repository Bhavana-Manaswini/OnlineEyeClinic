package com.cg.onlineeyecare.patient.dto;
import com.cg.onlineeyecare.report.dto.Report;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.OneToOne;
import com.cg.onlineeyecare.appointment.dto.Appointment;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
* the entity in the database*/
@Table(name="patients")
public class Patient implements Serializable{
	@Id//correspond to the primary key of the object's table
	@GeneratedValue(strategy=GenerationType.AUTO)//automatically generates the primary key value
	//@Column Specifies the mapped column for a persistent property
	@Column(name="PatientId",nullable=false)
	private int patientId;
	@Column(name="PatientName",nullable=false)
	private String patientName;
	@Column(name="PatientAge",nullable=false)
	private int patientAge;
	@Column(name="PatientMobile",nullable=false)
	private long patientMobile;
	@Column(name="PatientEmail",nullable=false)
	private String patientEmail;
	@DateTimeFormat(style = "yyyy-MM-dd")
	@Column(name="PatientDOB")
	private LocalDate patientDOB;
	@Column(name="PatientUsername")
	private String patientUsername;
	@Column(name="PatientPassword")
	private String patientPassword;
	@Column(name="PatientAddress")
	private String patientAddress;
	@Column(name="Appointment")
	private Appointment appointment;
	@OneToOne(mappedBy="patient")
	private Report report;
	//Constructor
	public Patient() {
		super();
	}
	//Parameterized constructor
	public Patient(int patientId, String patientName, int patientAge, long patientMobile, String patientEmail,
			LocalDate patientDOB, String patientUsername, String patientPassword, String patientAddress,
			Appointment appointment, Report report) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientDOB = patientDOB;
		this.patientUsername = patientUsername;
		this.patientPassword = patientPassword;
		this.patientAddress = patientAddress;
		this.appointment = appointment;
		this.report = report;
	}
	//getters and setters
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public long getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getPatientDOB() {
		return patientDOB;
	}
	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}
	public String getPatientUsername() {
		return patientUsername;
	}
	public void setPatientUsername(String patientUsername) {
		this.patientUsername = patientUsername;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMobile=" + patientMobile + ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB
				+ ", patientUserName=" + patientUsername + ", patientPassword=" + patientPassword + ", patientAddress="
				+ patientAddress + ", appointment=" + appointment + ", report=" + report +"]";
	}
	
}
