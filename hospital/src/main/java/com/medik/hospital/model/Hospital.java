package com.medik.hospital.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospitalId;
	
	@Column
	private String hospitalName;
	
	@Column
	private String hospitalLicense; 
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Doctors> doctors;
	
	public Hospital() {
		
	}	
	
	public Hospital(int hospitalId, String hospitalName, String hospitalLicense, Address address) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalLicense = hospitalLicense;
		this.address = address;
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
	public List<Doctors> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctors> doctors) {
		this.doctors = doctors;
	}
	
//
//	@Override
//	public String toString() {
//		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalLicense="
//				+ hospitalLicense + ", address=" + address + ", doctors=" + doctors + "]";
//	}
	
}
