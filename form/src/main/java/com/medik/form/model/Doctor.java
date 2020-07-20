package com.medik.form.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8445945047017515151L;

	@Id
	private int doctorId;
	
	@Column
	private String doctorEmailId;
	
	@Column
	private String doctorName;
	
	@Column
	private String doctorLicense;
	
	@Column
	private String specialization;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Form> form;
	
	public Doctor() {
		
	}

	public Doctor(int doctorId, String doctorEmailId, String doctorName, String doctorLicense, String specialization) {
		super();
		this.doctorId = doctorId;
		this.doctorEmailId = doctorEmailId;
		this.doctorName = doctorName;
		this.doctorLicense = doctorLicense;
		this.specialization = specialization;
	}



	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorEmailId() {
		return doctorEmailId;
	}

	public void setDoctorEmailId(String doctorEmailId) {
		this.doctorEmailId = doctorEmailId;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Form> getForm() {
		return form;
	}

	public void setForm(List<Form> form) {
		this.form = form;
	}
	
}
