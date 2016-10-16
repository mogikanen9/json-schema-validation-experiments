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
	
	class SimpleRequest implements Request{

		private String json;
		private String schema;
		
		public SimpleRequest(String json, String schema){
			this.schema = schema;
			this.json = json;
		}
		
		@Override
		public String getJson() {
			return this.json;
		}

		@Override
		public String getSchema() {
			return this.schema;
		}
		
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
	public void testInvalidValidPhysicianJsonData() throws Exception {

		String physicianSchema = readMainResource("/json/schema/basic/physician.json");

		String physicianData = readTestReosurce("/json/data/basic/physician-sample-invalid-1.json");

		Request request = new SimpleRequest(physicianData, physicianSchema);

		ValidationService service = new EveritJsonValidationServiceImpl();
		Response response = service.validate(request);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.isValid());

	}

}
