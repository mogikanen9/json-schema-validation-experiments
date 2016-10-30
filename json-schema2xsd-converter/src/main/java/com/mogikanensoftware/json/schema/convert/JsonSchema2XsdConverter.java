package com.mogikanensoftware.json.schema.convert;

import java.io.OutputStream;
import java.io.Reader;

public interface JsonSchema2XsdConverter {

	void convert(final Reader jsonSchema, final OutputStream xsdFileOut, final String targetNameSpaceUri,
			final String targetTypeName) throws ConverterException;
}
