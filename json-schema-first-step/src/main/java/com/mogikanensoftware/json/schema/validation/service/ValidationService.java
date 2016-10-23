package com.mogikanensoftware.json.schema.validation.service;

public interface ValidationService {

	Response validate(Request request) throws ValidationServiceException;
}
