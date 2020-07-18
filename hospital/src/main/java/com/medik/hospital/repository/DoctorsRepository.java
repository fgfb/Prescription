package com.medik.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medik.hospital.model.Doctors;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
	
	Doctors findBydoctorEmailId(final String doctorEmailId);

}
