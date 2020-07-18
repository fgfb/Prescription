package com.medik.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medik.form.model.Form;
import com.medik.form.model.Hospital;

@RepositoryRestResource
public interface FormRepository extends JpaRepository<Hospital, Integer>, JpaSpecificationExecutor<Form>{

}
