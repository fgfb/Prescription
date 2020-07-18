package com.medik.form.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospital implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707493477381825420L;

	@Id
	private int hospitalId;
	
	@Column
	private String hospitalName;
	
	@Column
	private String hospitalLicense;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Doctor doctor;
	
	public Hospital() {
		
	}

	public Hospital(int hospitalId, String hospitalName, String hospitalLicense, Address address, Doctor doctor) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalLicense = hospitalLicense;
		this.address = address;
		this.doctor = doctor;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalLicense() {
		return hospitalLicense;
	}

	public void setHospitalLicense(String hospitalLicense) {
		this.hospitalLicense = hospitalLicense;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
