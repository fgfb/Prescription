package com.medik.form.service;

import java.util.Optional;

import com.medik.form.model.Form;

public interface FormService {
	
	public Form createForm(Form form);
	
	public Optional<Form> searchFormByFormId(String formId);
	
	

}
