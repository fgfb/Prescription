package com.medik.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medik.hospital.model.Doctor_Credentials;

@Repository
public interface CredentailsRepository extends JpaRepository<Doctor_Credentials, String> {
	
}
