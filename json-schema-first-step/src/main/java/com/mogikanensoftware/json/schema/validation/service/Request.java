package com.mogikanensoftware.json.schema.validation.service;

import java.net.URI;

public interface Request {

	String getJson();
	String getSchemaContent();
	URI getSchemaURI();
}
