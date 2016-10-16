package com.mogikanensoftware.json.schema.validation.service.impl;

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
			  try{
				  schema.validate(new JSONObject(request.getJson()));
				  return ()->true;
			  }catch(ValidationException ve){
				  System.err.println(ve.getMessage());
				  return ()->false;
			  }
			  
	}

}
