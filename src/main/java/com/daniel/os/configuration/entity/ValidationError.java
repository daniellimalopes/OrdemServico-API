package com.daniel.os.configuration.entity;

import java.util.ArrayList;
import java.util.List;



public class ValidationError extends StandardError {
	
	
	
	private List<FieldMensage> errors = new ArrayList<>(); 
	
	public ValidationError(Integer status, String msg, Long timeStamo) {
		super(status, msg, timeStamo);
		
	}

	public List<FieldMensage> getErrors() {
		return errors;
	}

	public void AddError (String fieldName, String messagem) {
		errors.add(new FieldMensage(fieldName, messagem));
	}

	

}
