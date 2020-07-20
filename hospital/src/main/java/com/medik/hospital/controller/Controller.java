package com.medik.hospital.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medik.hospital.model.Doctor_Credentials;
import com.medik.hospital.model.Doctors;
import com.medik.hospital.model.Hospital;
import com.medik.hospital.repository.CredentailsRepository;
import com.medik.hospital.repository.DoctorsRepository;
import com.medik.hospital.repository.HospitalRepository;
import com.medik.hospital.util.CreateCredentials;

/**
 * @author Jathin
 *
 */
@RestController
@RequestMapping(value = "api/v1/medik")
public class Controller {
	
	@Autowired
	private HospitalRepository hospitalRepo;
	
	@Autowired
	private CredentailsRepository credentailsRepo;
	
	@Autowired
	private CreateCredentials credentials;
	
	@Autowired
	private DoctorsRepository doctorsRepo;
	
	/* Add a Hospital */
	
	@PostMapping(value = "/hospital")
	public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
		return new ResponseEntity<Hospital>(hospitalRepo.save(hospital), HttpStatus.OK);
	}
	
	/* Get all Hospitals */
	
	@RequestMapping(value = "/hospital", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Hospital>> getAllHospitals(){
		Iterable<Hospital> hospitalList = hospitalRepo.findAll();
		return new ResponseEntity<Iterable<Hospital>>(hospitalList, HttpStatus.OK);
	}
	
	/* Get a hospital by Id */
	
	@GetMapping(value = "/hospital/{hospitalId}")
	public ResponseEntity<Optional<Hospital>> getHospitalById(@PathVariable(value = "hospitalId") int hospitalId) {
		Optional<Hospital> hospital = hospitalRepo.findById(hospitalId);
		return new ResponseEntity<Optional<Hospital>>(hospital, HttpStatus.OK);
	}
	
	/* Get Hospital By Name */
	
	@RequestMapping(value = "/hospitalname/{hospitalName}", method = RequestMethod.GET)
	public ResponseEntity<Hospital> getHositalByName(@PathVariable (value = "hospitalName") String hospitalName){
		Hospital hospital = hospitalRepo.findByhospitalName(hospitalName);
		return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}
	
	/* Delete hospital from Database */
	
	@RequestMapping(value = "/hospital/{hospitalId}", method = RequestMethod.DELETE)
	public String deleteHospital(@PathVariable(value = "hospitalId") int hospitalId) {
		hospitalRepo.deleteById(hospitalId);
		return "OK";
	}
	
	/* Add Doctor under a hospital */

	@PutMapping(value = "/hospital/{hospitalId}/doctors")
	public ResponseEntity<Hospital> addDoctor(@PathVariable(value = "hospitalId") int hospitalId, @RequestBody Doctors doctors) {

		Optional<Hospital> optionalHospital = hospitalRepo.findById(hospitalId);
		Hospital hospital = optionalHospital.get();
		
		Iterator<Doctors> doctorsIterator = hospital.getDoctors().iterator();
		
		List<Doctors> doctorsList = new ArrayList<Doctors>();
		
		while(doctorsIterator.hasNext()) {
			
			Doctors doc = doctorsIterator.next();
			doctorsList.add(doc);
		}
		
		doctorsList.add(doctors);
		hospital.setDoctors(doctorsList);
		doctors.setHospital(hospital);
		hospitalRepo.save(hospital);
		
		Doctors doc = doctorsRepo.findBydoctorEmailId(doctors.getDoctorEmailId());
		
		credentials.creatingCredentials(doc);
		
		return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}
	
	/* Get all the doctors under a hospital */
	
	@GetMapping(value = "/hospital/{hospitalId}/doctors")
	public ResponseEntity<List<Doctors>> getAllDoctorsUnderHospitalById(@PathVariable(value = "hospitalId") int hospitalId){
		List<Doctors> doctors = hospitalRepo.findById(hospitalId).get().getDoctors();
		return new ResponseEntity<List<Doctors>>(doctors, HttpStatus.OK);
	}
	
	/* Get doctor under a hospital by ID*/
	
	@GetMapping(value = "/hospital/{hospitalId}/doctors/{doctorId}")
	public ResponseEntity<Doctors> getADoctorUnderHospitalById(@PathVariable(value = "hospitalId") int hospitalId, 
			@PathVariable(value = "doctorId") int doctorId){
		Iterator<Doctors> doctors = hospitalRepo.findById(hospitalId).get().getDoctors().iterator();
		Doctors doc = new Doctors();
		while(doctors.hasNext()) {
			Doctors docto = doctors.next();
			if(docto.getDoctorId() == doctorId) {
				doc = docto;
			}
		}	
		return new ResponseEntity<Doctors>(doc, HttpStatus.OK);
	}
	
	/* Get the doctor by doctor email id*/
	
	@GetMapping(value = "/doctor/{doctorEmailId}")
	public ResponseEntity<Doctors> getDoctorById(@PathVariable(value = "doctorEmailId") String doctorEmailId){
		Doctors doctor = doctorsRepo.findBydoctorEmailId(doctorEmailId);
		return new ResponseEntity<Doctors>(doctor,HttpStatus.OK);
	}
	
	/* Get the Hospital Details by a Doctor EmailID */
	
	@GetMapping(value = "/doctors/{doctorEmailId}")
	public ResponseEntity<Hospital> getHospitalByDoctorId(@PathVariable(value = "doctorEmailId") String doctorEmailId){
		
		Hospital hospital = hospitalRepo.findAllwithDoctorEmailQuery(doctorEmailId);
		
		return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}
	
	/* Get Credentials from Email ID */
	
	@GetMapping(value = "/credentials/{doctorEmailId}")
	public ResponseEntity<Doctor_Credentials> getCredentialsByEmailId(@PathVariable(value = "doctorEmailId") String doctorEmailId){
		
		Optional<Doctor_Credentials> optionalCredentials = credentailsRepo.findById(doctorEmailId);
		
		Doctor_Credentials credentials = optionalCredentials.get();
		
		return new ResponseEntity<Doctor_Credentials>(credentials, HttpStatus.OK);
		
	}
	
}
