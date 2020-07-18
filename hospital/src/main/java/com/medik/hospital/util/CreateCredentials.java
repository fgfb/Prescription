package com.medik.hospital.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medik.hospital.model.Doctor_Credentials;
import com.medik.hospital.model.Doctors;
import com.medik.hospital.repository.CredentailsRepository;

@Component
public class CreateCredentials {

	@Autowired
	private CredentailsRepository credentialRepo;

	
	public Doctor_Credentials creatingCredentials(Doctors doctor) {
		Doctor_Credentials credentials = new Doctor_Credentials();
		
		String email= doctor.getDoctorEmailId();
		
		//int id = doctor.getDoctorId();
		String checkEmail = credentialRepo.findById(email).toString();
		
		if(!checkEmail.isBlank() || !checkEmail.isEmpty()) {
			credentials.setDoctorId(doctor.getDoctorId());
			credentials.setEmailId(doctor.getDoctorEmailId());
			String password = doctor.getDoctorName().split(" ")[0].toString().toLowerCase();
			credentials.setPassword(password);
			
			credentialRepo.save(credentials);
		}
		
		return credentials;
	}
	
}
