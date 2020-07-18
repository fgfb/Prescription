package com.medik.hospital.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctors implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	
	private String doctorName;
	
	private String doctorLicense;
	
	private String doctorEmailId;

	private String specialization;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_id", referencedColumnName = "hospitalId")
	private Hospital hospital;
	
	public Doctors() {
		
	}

	public Doctors(int doctorId, String doctorName, String doctorLicense, String doctorEmailId, String specialization) {
		this.doctorName = doctorName;
		this.doctorLicense = doctorLicense;
		this.doctorEmailId = doctorEmailId;
		this.specialization = specialization;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorLicense() {
		return doctorLicense;
	}

	public void setDoctorLicense(String doctorLicense) {
		this.doctorLicense = doctorLicense;
	}

	public String getDoctorEmailId() {
		return doctorEmailId;
	}

	public void setDoctorEmailId(String doctorEmailId) {
		this.doctorEmailId = doctorEmailId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@JsonIgnore
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Doctors [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorLicense=" + doctorLicense
				+ ", doctorEmailId=" + doctorEmailId + ", specialization=" + specialization + "]";
	}

}
