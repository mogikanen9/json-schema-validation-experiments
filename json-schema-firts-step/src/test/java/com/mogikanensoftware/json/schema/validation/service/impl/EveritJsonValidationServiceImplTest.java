package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.mogikanensoftware.json.schema.validation.service.Request;
import com.mogikanensoftware.json.schema.validation.service.Response;
import com.mogikanensoftware.json.schema.validation.service.ValidationService;

public class EveritJsonValidationServiceImplTest {

	protected String readMainResource(String relativePath) throws IOException{
		return new String(Files.readAllBytes(Paths.get(
				EveritJsonValidationServiceImpl.class.getResource(relativePath).getPath())));
	}
	
	protected String readTestReosurce(String relativePath) throws IOException{
		return new String(Files.readAllBytes(Paths.get(
				EveritJsonValidationServiceImpl.class.getResource(relativePath).getPath())));
	}
	
	
	@Test
	public void testValidPhysicianJsonData() throws Exception {

		String physicianSchema = readMainResource("/json/schema/basic/physician.json");

		String physicianData = readTestReosurce("/json/data/basic/physician-sample-valid-1.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}
	
	@Test
	public void testInvalidJsonDataMissingFirstName() throws Exception {

		String physicianSchema = readMainResource("/json/schema/basic/physician.json");

		String physicianData = readTestReosurce("/json/data/basic/physician-sample-invalid-no-firstname.json");

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

		String physicianSchema = readMainResource("/json/schema/basic/physician.json");

		String physicianData = readTestReosurce("/json/data/basic/physician-sample-invalid-no-cpso.json");

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

		String physicianSchema = readMainResource("/json/schema/basic/physician.json");

		String physicianData = readTestReosurce("/json/data/basic/physician-sample-valid-2.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isValid());

	}
	
	@Test
	public void testInvalidJsonDataPracticeYear0() throws Exception {

		String physicianSchema = readMainResource("/json/schema/basic/physician.json");

		String physicianData = readTestReosurce("/json/data/basic/physician-sample-invalid-practice-years.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());
		Assert.assertNotNull(response.getErrorMessages());
		Assert.assertFalse(response.getErrorMessages().isEmpty());
		response.getErrorMessages().forEach(System.out::println);

	}
}
