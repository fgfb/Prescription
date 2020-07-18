package com.medik.form.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.medik.form.model.Doctor;
import com.medik.form.model.Hospital;

@Component
public class FetchHospitalObj {
	
	@Autowired
	RestTemplate template;
	
	public Hospital getHospital(String doctorEmailId) {
		
		String url = "http://localhost:8080/api/v1/medik/doctors/" + doctorEmailId;
		String url1 = "http://localhost:8080/api/v1/medik/doctor/" + doctorEmailId;
		
		Hospital hospital = template.getForObject(url, Hospital.class);
		Doctor doctor = template.getForObject(url1, Doctor.class);
		
		hospital.setDoctor(doctor);
		
		return hospital;
	}

}
