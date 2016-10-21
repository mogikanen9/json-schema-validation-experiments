package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.Serializable;
import java.net.URI;

import com.mogikanensoftware.json.schema.validation.service.Request;

public class SimpleRequest implements Request, Serializable {

	private static final long serialVersionUID = 1L;

	private String json;
	private URI schemaURI;
	private String schemaContent;

	public SimpleRequest(String json, String schemaContent) {
		this.schemaContent = schemaContent;
		this.json = json;
	}

	public SimpleRequest(String json, URI schemaURI) {
		this.schemaURI = schemaURI;
		this.json = json;
	}

	public String getJson() {
		return json;
	}

	
	public URI getSchemaURI() {
		return schemaURI;
	}

	public String getSchemaContent() {
		return schemaContent;
	}

}
