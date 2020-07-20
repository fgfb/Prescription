package com.medik.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medik.form.model.Hospital;

@RepositoryRestResource
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
