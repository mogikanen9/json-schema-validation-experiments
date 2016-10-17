package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mogikanensoftware.json.schema.validation.service.Response;

public class SimpleResponse implements Response, Serializable {

	private static final long serialVersionUID = 1L;

	private boolean valid;
	private List<String> errorMessages;
	
	
	public SimpleResponse(boolean valid, List<String> errorMessages) {
		super();
		this.valid = valid;
		this.errorMessages = errorMessages;
	}

	public SimpleResponse(boolean valid){
		this(valid, new ArrayList<>());
	}
	
	@Override
	public boolean isValid() {
		return this.valid;
	}

	@Override
	public List<String> getErrorMessages() {
		return this.errorMessages;
	}

}
