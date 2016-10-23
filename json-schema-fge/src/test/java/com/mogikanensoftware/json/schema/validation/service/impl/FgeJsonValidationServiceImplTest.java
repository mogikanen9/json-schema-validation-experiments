package com.mogikanensoftware.json.schema.validation.service.impl;

import com.mogikanensoftware.json.schema.validation.service.test.AbstractJsonValidationServiceTest;

public class FgeJsonValidationServiceImplTest extends AbstractJsonValidationServiceTest {

	public FgeJsonValidationServiceImplTest() throws Exception {
		super.init();
		
		service = new FgeJsonValidationServiceImpl();
	}

}
