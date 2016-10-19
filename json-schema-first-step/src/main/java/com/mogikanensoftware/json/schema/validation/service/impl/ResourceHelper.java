package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceHelper {

	public String readResource(Class clazz, String relativePath) throws IOException {
		String path =clazz.getResource(relativePath).getPath();
		if (path.startsWith("/") && System.getProperty("os.name").contains("indow")) {
			path = path.substring(1);
		}
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
