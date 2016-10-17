package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.mogikanensoftware.json.schema.validation.service.AbstractTest;
import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;

public class EveritJsonValidationServiceImplTest extends AbstractTest{	

	private String physicianSchema; 
	private String messageSchema;
		
	public EveritJsonValidationServiceImplTest() throws IOException{
		 physicianSchema = readResource("/json/schema/basic/physician.json");
		 messageSchema = readResource("/json/schema/basic/message.json");
	}
	
	@Test
	public void testValidPhysicianJsonData() throws Exception {
	
		String physicianData = readResource("/json/data/basic/physician-sample-valid-1.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}

	@Test
	public void testInvalidJsonDataMissingFirstName() throws Exception {		

		String physicianData = readResource("/json/data/basic/physician-sample-invalid-no-firstname.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}

	@Test
	public void testInvalidJsonDataMissingCpso() throws Exception {

		String physicianData = readResource("/json/data/basic/physician-sample-invalid-no-cpso.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}

	@Test
	public void testValidPhysicianJsonData2() throws Exception {		

		String physicianData = readResource("/json/data/basic/physician-sample-valid-2.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}

	@Test
	public void testInvalidJsonDataPracticeYear0() throws Exception {		

		String physicianData = readResource("/json/data/basic/physician-sample-invalid-practice-years.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}
	
	@Test
	public void testValidPhysicianJsonDataWithClinic() throws Exception {		

		String physicianData = readResource("/json/data/basic/physician-sample-valid-with-clinic.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}
	
	@Test
	public void testValidMessageJsonData1() throws Exception {		

		String messageData = readResource("/json/data/basic/message-sample-valid-1.json");

		Request request = new SimpleRequest(messageData, messageSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}
	
	@Test
	public void testInValidMessageJsonDataMIssingSFId() throws Exception {		

		String messageData = readResource("/json/data/basic/message-sample-invalid-missing-sfid.json");

		Request request = new SimpleRequest(messageData, messageSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());

	}
}
