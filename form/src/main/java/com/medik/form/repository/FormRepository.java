package com.medik.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.medik.form.model.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer>, JpaSpecificationExecutor<Form>{

}
