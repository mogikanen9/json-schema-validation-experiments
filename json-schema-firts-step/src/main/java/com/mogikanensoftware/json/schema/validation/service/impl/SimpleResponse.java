package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.mogikanensoftware.json.schema.validation.service.Response;

public class SimpleResponse implements Response, Serializable {

	private static final long serialVersionUID = 1L;

	private boolean valid;
	private Collection<String> errorMessages;

	public SimpleResponse(boolean valid, Collection<String> errorMessages) {
		super();
		this.valid = valid;
		this.errorMessages = errorMessages;
	}

	public SimpleResponse(boolean valid) {
		this(valid, new ArrayList<>());
	}

	@Override
	public boolean isValid() {
		return this.valid;
	}

	@Override
	public Collection<String> getErrorMessages() {
		return this.errorMessages;
	}

}
