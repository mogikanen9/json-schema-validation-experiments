package com.mogikanensoftware.xsd.schema;

import java.io.OutputStream;

public interface JsonSchemaGenerator {

	void generate(final String fullyQualifiedClassName, OutputStream out) throws JsonSchemaGeneratorException;
}
