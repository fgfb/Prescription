package com.medik.form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medik.form.model.Form;
import com.medik.form.model.Hospital;
import com.medik.form.repository.FormRepository;
import com.medik.form.repository.HospitalRepository;
//import com.medik.form.repository.FormRepository;
import com.medik.form.util.FetchHospitalObj;
import com.sipios.springsearch.anotation.SearchSpec;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/medik")
public class formController {
	
	
	@Autowired
	private HospitalRepository repo;
	
	@Autowired
	private FormRepository formRepo;
	
	@Autowired
	private FetchHospitalObj obj;
	
	@GetMapping(value = "/formsQuery")
	public ResponseEntity<List<Form>> searchForm(@SearchSpec Specification<Form> specs) {
		return new ResponseEntity<List<Form>>(formRepo.findAll(Specification.where(specs)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/form")
	public ResponseEntity<List<Form>> getAllForms(){
		return new ResponseEntity<List<Form>>(formRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/form/{formId}")
	public ResponseEntity<Form> getFormById(@PathVariable(value = "formId") int formId){
		return new ResponseEntity<Form>(formRepo.findById(formId).get(), HttpStatus.OK);
	}
	
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
