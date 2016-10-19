package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;

import org.junit.Assert;

import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;

public class FgeJsonValidationServiceImplTest{

	private String physicianSchema; 
	private ResourceHelper resourceHelper = new ResourceHelper();
	
	public FgeJsonValidationServiceImplTest() throws IOException{
		 physicianSchema = resourceHelper.readResource(FgeJsonValidationServiceImplTest.class,"/json/schema/basic/physician.json");
	}
	
	
	public void invalidJsonDataMissingFirstName() throws Exception {		

		String physicianData = resourceHelper.readResource(FgeJsonValidationServiceImplTest.class,"/json/data/basic/physician-sample-invalid-no-firstname.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new FgeJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}
}
