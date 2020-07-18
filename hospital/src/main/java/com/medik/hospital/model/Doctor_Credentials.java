package com.medik.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor_Credentials implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String emailId;
	
	@Column
	private int doctorId;

	@Column
	private String password;

	public Doctor_Credentials() {
		
	}
	
	public Doctor_Credentials(String emailId, int doctorId, String password) {
		super();
		this.emailId = emailId;
		this.doctorId = doctorId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Doctor_Credentials [emailId=" + emailId + ", doctorId=" + doctorId + ", password=" + password + "]";
	}

}
