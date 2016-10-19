package com.mogikanensoftware.json.schema.validation.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.mogikanensoftware.json.schema.validation.service.impl.EveritJsonValidationServiceImpl;

public abstract class AbstractTest {

	protected String readResource(String relativePath) throws IOException {
		String path = EveritJsonValidationServiceImpl.class.getResource(relativePath).getPath();
		if (path.startsWith("/") && System.getProperty("os.name").contains("indow")) {
			path = path.substring(1);
		}
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
