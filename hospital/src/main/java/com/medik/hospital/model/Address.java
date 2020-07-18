package com.medik.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	
	private String doorNo;

	private String streetName;

	private String addressLine1;

	private String city;

	private String state;

	private String country;

	private String postcode;
	
	public Address() {
		
	}
	
	public Address(String doorNo, String streetName, String addressLine1, String city, String state, String country,
			String postcode) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postcode = postcode;
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

	public void setPostCode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", addressLine1=" + addressLine1 + ", city="
				+ city + ", state=" + state + ", country=" + country + ", postcode=" + postcode + "]";
	}
	
}
