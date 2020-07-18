package com.medik.form.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4418521038802253765L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String medicineName;
	
	@Column
	private String medicineType;
	
	@Column
	private int quantity;
	
	@Column
	private int noOfTimesADay;
	
	@Column
	private int durationOfCourse;
	
	public Medicine() {
		
	}

	public Medicine(int id, String medicineName, String medicineType, int quantity, int noOfTimesADay,
			int durationOfCourse) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.medicineType = medicineType;
		this.quantity = quantity;
		this.noOfTimesADay = noOfTimesADay;
		this.durationOfCourse = durationOfCourse;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNoOfTimesADay() {
		return noOfTimesADay;
	}

	public void setNoOfTimesADay(int noOfTimesADay) {
		this.noOfTimesADay = noOfTimesADay;
	}

	public int getDurationOfCourse() {
		return durationOfCourse;
	}

	public void setDurationOfCourse(int durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
	}

}
