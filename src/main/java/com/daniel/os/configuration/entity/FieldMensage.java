package com.daniel.os.configuration.entity;

public class FieldMensage {
	
	private String fieldName;
	private String message;
	
	@SuppressWarnings("unused")
	private FieldMensage() {
	}

	public FieldMensage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}


