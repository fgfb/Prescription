package com.medik.form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medik.form.model.Form;
import com.medik.form.model.Hospital;
import com.medik.form.repository.FormRepository;
//import com.medik.form.repository.FormRepository;
import com.medik.form.util.FetchHospitalObj;
import com.sipios.springsearch.anotation.SearchSpec;


@RestController
@RequestMapping(value = "/api/v1/medik")
public class formController {
	
	
	@Autowired
	private FormRepository repo;
	
	@Autowired
	private FetchHospitalObj obj;
	
//	@GetMapping(value = "/form")
//	public ResponseEntity<List<Form>> searchForm(@SearchSpec Specification<Form> specs) {
//		return new ResponseEntity<List<Form>>(repo.findAll(Specification.where(specs)), HttpStatus.OK);
//	}
	
	@PostMapping(value = "/form/{doctorEmailId}")
	public ResponseEntity<Hospital> createPrescriptionForm(@PathVariable(value = "doctorEmailId") String doctorEmailId, @RequestBody Form form) {
		
		Hospital hospital = obj.getHospital(doctorEmailId);
		
		List<Form> formList = new ArrayList<>();
		
		formList.add(form);
		
		hospital.getDoctor().setForm(formList);
		
		//form.setDoctor(hospital.getDoctor());
	
		
		return new ResponseEntity<Hospital>(repo.save(hospital), HttpStatus.OK);
	}

}



//form.getHospitalTO().setHospitalId(hospital.getHospitalId());
//form.getHospitalTO().setHospitalName(hospital.getHospitalName());
//form.getHospitalTO().setHospitalLicense(hospital.getHospitalLicense());
//
//form.getHospitalTO().getAddressTO().setDoorNo(hospital.getAddress().getDoorNo());
//form.getHospitalTO().getAddressTO().setAddressLine1(hospital.getAddress().getAddressLine1());
//form.getHospitalTO().getAddressTO().setStreetName(hospital.getAddress().getStreetName());
//form.getHospitalTO().getAddressTO().setCity(hospital.getAddress().getCity());
//form.getHospitalTO().getAddressTO().setCountry(hospital.getAddress().getCountry());
//form.getHospitalTO().getAddressTO().setPostcode(hospital.getAddress().getPostcode());
//form.getHospitalTO().getAddressTO().setState(hospital.getAddress().getState());
//
//form.getHospitalTO().getDoctorTO().setDoctorId(hospital.getDoctor().getDoctorId());
//form.getHospitalTO().getDoctorTO().setDoctorEmailId(hospital.getDoctor().getDoctorEmailId());
//form.getHospitalTO().getDoctorTO().setDoctorLicense(hospital.getDoctor().getDoctorLicense());
//form.getHospitalTO().getDoctorTO().setDoctorName(hospital.getDoctor().getDoctorName());
//form.getHospitalTO().getDoctorTO().setSpecialization(hospital.getDoctor().getSpecialization());
