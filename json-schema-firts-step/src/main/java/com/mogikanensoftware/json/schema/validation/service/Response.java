package com.mogikanensoftware.json.schema.validation.service;

import java.util.List;

public interface Response {

	boolean isValid();
	List<String> getErrorMessages();
}
