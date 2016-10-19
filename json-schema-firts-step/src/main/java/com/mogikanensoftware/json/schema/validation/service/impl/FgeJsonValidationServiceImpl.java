package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;
import com.mogikanensoftware.json.schema.validation.service.ValidationServiceException;

public class FgeJsonValidationServiceImpl implements ValidationService {

	@Override
	public Response validate(Request request) throws ValidationServiceException {
		JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		JsonValidator validator = factory.getValidator();
		JsonNode schemaNode;
		try {
			schemaNode = JsonLoader.fromResource(request.getSchema());
			JsonNode jsonNode = JsonLoader.fromResource(request.getJson());
			ProcessingReport report = validator.validate(schemaNode, jsonNode);
			return new SimpleResponse(report.isSuccess());
		} catch (IOException e) {
			throw new ValidationServiceException(e.getMessage(), e);
		} catch (ProcessingException pe) {
			// todo check
			throw new ValidationServiceException(pe.getMessage(), pe);

		}

	}

}
