package com.mogikanensoftware.json.schema.validation.service.test;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;

import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;
import com.mogikanensoftware.json.schema.validation.service.impl.ResourceHelper;
import com.mogikanensoftware.json.schema.validation.service.impl.SimpleRequest;

public abstract class AbstractJsonValidationServiceTest {

	protected String physicianSchemaContent; 
	protected String messageSchemaContent;
	
	private URI physicianSchemaURI;
	private URI messageSchemaURI; 
	
	protected ResourceHelper resourceHelper = new ResourceHelper();
	
	protected ValidationService service;
	
	protected void init() throws Exception{
		physicianSchemaContent = resourceHelper.readResource("/json/schema/basic/physician.json");
		messageSchemaContent = resourceHelper.readResource("/json/schema/basic/message.json");
		physicianSchemaURI = new URI("https://raw.githubusercontent.com/mogikanen9/json-schema-validation-experiments/basic-validation-with-everit-org/schemas/physician.json");
		messageSchemaURI = new URI("https://raw.githubusercontent.com/mogikanen9/json-schema-validation-experiments/basic-validation-with-everit-org/schemas/message.json");
	}
	
	@Test
	public void testInvalidJsonDataMissingFirstName() throws Exception {		

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-invalid-no-firstname.json");

		Request request = new SimpleRequest(physicianData, physicianSchemaContent, physicianSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}

	@Test
	public void testInvalidJsonDataMissingCpso() throws Exception {

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-invalid-no-cpso.json");

		Request request = new SimpleRequest(physicianData, physicianSchemaContent, physicianSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}


	@Test
	public void testInvalidJsonDataPracticeYear0() throws Exception {		

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-invalid-practice-years.json");

		Request request = new SimpleRequest(physicianData, physicianSchemaContent, physicianSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}
	
	@Test
	public void testValidPhysicianJsonDataWithClinic() throws Exception {		

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-valid-with-clinic.json");

		Request request = new SimpleRequest(physicianData, physicianSchemaContent, physicianSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}
	
	@Test
	public void testValidMessageJsonData1() throws Exception {		

		String messageData = resourceHelper.readResource("/json/data/basic/message-sample-valid-1.json");

		Request request = new SimpleRequest(messageData, messageSchemaContent,messageSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}
	
	@Test
	public void testInValidMessageJsonDataMIssingSFId() throws Exception {		

		String messageData = resourceHelper.readResource("/json/data/basic/message-sample-invalid-missing-sfid.json");

		Request request = new SimpleRequest(messageData, messageSchemaContent,messageSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertTrue(response.getErrorMessages().size()>0);
	}
	
	@Test
	public void testInvalidJsonDataBadClinicAddress() throws Exception {		

		String physicianData = resourceHelper.readResource("/json/data/basic/physician-sample-invalid-clinic-bad-address.json");

		Request request = new SimpleRequest(physicianData, physicianSchemaContent, physicianSchemaURI);

		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		Assert.assertTrue(response.getErrorMessages().size()>0);
		boolean streetErrMsgFound = false;
		boolean postalCodeErrMsgFound = false;
		for (String errorMassage:response.getErrorMessages()) {
			if(!streetErrMsgFound){
				streetErrMsgFound = errorMassage.indexOf("street")!=-1;
			}
			if(!postalCodeErrMsgFound){
				postalCodeErrMsgFound = errorMassage.indexOf("postalCode")!=-1;
			}
			
			System.out.println(errorMassage);
		}
		Assert.assertTrue(streetErrMsgFound);
	}
}
