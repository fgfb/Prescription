package com.medik.form.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3308767033698075707L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	@Column
	private String patientFirstName;
	
	@Column
	private String patientLame;
	
	@Column
	private String gender;
	
	@Column
	private int age;
	
	public Patient() {
		
	}

	public Patient(int patientId, String patientFirstName, String patientLame, String gender, int age) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLame = patientLame;
		this.gender = gender;
		this.age = age;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLame() {
		return patientLame;
	}

	public void setPatientLame(String patientLame) {
		this.patientLame = patientLame;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLame="
				+ patientLame + ", gender=" + gender + ", age=" + age + "]";
	}

}
