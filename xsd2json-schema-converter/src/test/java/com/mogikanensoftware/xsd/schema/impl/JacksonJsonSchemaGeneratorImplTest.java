package com.mogikanensoftware.xsd.schema.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mogikanensoftware.xsd.schema.JsonSchemaGenerator;
import com.mogikanensoftware.xsd.schema.JsonSchemaGeneratorException;

public class JacksonJsonSchemaGeneratorImplTest {

	private JsonSchemaGenerator generator;
	
	@Before
	public void setUp() throws Exception {
		generator = new JacksonJsonSchemaGeneratorImpl();
	}

	@After
	public void tearDown() throws Exception {
		generator = null;
	}

	@Test
	public void testGenerate() throws JsonSchemaGeneratorException {
		generator.generate("com.mogikanensoftware.xsd.schema.physician.Physician", System.out);
	}

}
