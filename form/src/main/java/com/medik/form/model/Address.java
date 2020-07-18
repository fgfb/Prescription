package com.medik.form.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8468197363619361636L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	
	@Column
	private String doorNo;
	
	@Column
	private String streetName;

	@Column
	private String addressLine1;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String country;

	@Column
	private String postcode;

	public Address() {
		
	}
	
	public Address(Long addressId,String doorNo, String streetName, String addressLine1, String city, String state,
			String country, String postcode) {
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postcode = postcode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
