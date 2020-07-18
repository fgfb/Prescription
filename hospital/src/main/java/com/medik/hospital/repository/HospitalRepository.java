package com.medik.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medik.hospital.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	Hospital findByhospitalName(final String hospitalName);
	
	@Query("Select h from Hospital h left join Doctors d on h.hospitalId = d.doctorId where d.doctorEmailId = :doctorEmailId")
	public Hospital findAllwithDoctorEmailQuery(String doctorEmailId);
	
}
