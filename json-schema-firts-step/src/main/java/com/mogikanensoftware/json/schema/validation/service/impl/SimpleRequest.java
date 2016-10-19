package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.Serializable;

import com.mogikanensoftware.json.schema.validation.service.Request;

public class SimpleRequest implements Request, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String json;
	private String schema;
	
	public SimpleRequest(String json, String schema){
		this.schema = schema;
		this.json = json;
	}
	
	@Override
	public String getJson() {
		return this.json;
	}

	@Override
	public String getSchema() {
		return this.schema;
	}

}
