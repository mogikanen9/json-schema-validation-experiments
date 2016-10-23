package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;
import com.mogikanensoftware.json.schema.validation.service.ValidationServiceException;

public class FgeJsonValidationServiceImpl implements ValidationService {

	@Override
	public Response validate(Request request) throws ValidationServiceException {	
		try {
			

			final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

			final JsonSchema schemaValidator = factory.getJsonSchema(request.getSchemaURI().toString());
				      
			final JsonNode jsonNode = new ObjectMapper().readTree(request.getJson());
					
			ProcessingReport report = schemaValidator.validate(jsonNode);						
			
			SimpleResponse response = new SimpleResponse(report.isSuccess());
			
			//add all error messages to reponse
			if(!report.isSuccess()){
				report.forEach((processingMessage)->{response.getErrorMessages().add(processingMessage.getMessage());});
			}
			
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ValidationServiceException(e.getMessage(), e);
		} catch (ProcessingException pe) {
			// todo check
			throw new ValidationServiceException(pe.getMessage(), pe);

		}

	}

}
