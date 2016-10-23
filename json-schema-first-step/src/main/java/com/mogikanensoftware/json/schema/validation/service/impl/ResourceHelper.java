package com.mogikanensoftware.json.schema.validation.service.impl;

import java.io.IOException;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

public class ResourceHelper {		
	
	public String readResource(String relativePath) throws IOException {
		
		String resourceContent = IOUtils.readLines(ResourceHelper.class.getResourceAsStream(relativePath),"UTF-8")
				.stream().collect(Collectors.joining());
		return resourceContent;
		
		
	}
}
