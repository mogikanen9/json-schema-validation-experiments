package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;

public class FgeJsonValidationServiceImplTest{

	private URI physicianSchema; 
	private ResourceHelper resourceHelper = new ResourceHelper();
	
	public FgeJsonValidationServiceImplTest() throws IOException, URISyntaxException{
		 physicianSchema = new URI("https://raw.githubusercontent.com/mogikanen9/json-schema-validation-experiments/basic-validation-with-everit-org/schemas/physician.json");
	}
	
	@Test
	public void validPhysicianJsonWithClinic() throws Exception {		

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-valid-with-clinic.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new FgeJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertTrue(response.getErrorMessages().isEmpty());		

	}
	
	@Test
	public void invalidPhysicianJsonNoFirstName() throws Exception {		

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-invalid-no-firstname.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new FgeJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		System.out.println("invalidPhysicianJsonNoFirstName(): errorMsags->\n");
		response.getErrorMessages().forEach(System.out::println);

	}
}
