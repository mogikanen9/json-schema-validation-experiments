package com.mogikanensoftware.json.schema.validation.service;

import java.util.Collection;

public interface Response {

	boolean isValid();
	Collection<String> getErrorMessages();
}
