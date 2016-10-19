package com.mogikanensoftware.json.schema.validation.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;

public class EveritJsonValidationServiceImpl implements ValidationService {

	public Response validate(Request request) {

		JSONObject rawSchema = new JSONObject(request.getSchema());
		Schema schema = SchemaLoader.load(rawSchema);
		
		try {
			schema.validate(new JSONObject(request.getJson()));
			return new SimpleResponse(true);
		} catch (ValidationException ve) {

			ve.printStackTrace();
			
			Set<String> validationErrors = new HashSet<>();
			validationErrors.add(ve.getErrorMessage());

			if (ve.getCausingExceptions().size() > 1) {
				validationErrors.addAll(ve.getCausingExceptions().stream().map(ValidationException::getErrorMessage)
						.collect(Collectors.toSet()));
			}

			return new SimpleResponse(false, validationErrors);
		}
	}

}
