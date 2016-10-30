package com.mogikanensoftware.json.schema.convert.impl;

import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.mogikanensoftware.json.schema.convert.JsonSchema2XsdConverter;
import com.mogikanensoftware.json.schema.convert.XMLHelper;

public class EthloJsonSchema2XsdConverterImplTest {

	private XMLHelper helper;
	private JsonSchema2XsdConverter converter;

	@Before
	public void setUp() {
		helper = new SimpleXMLHelperImpl();
		converter = new EthloJsonSchema2XsdConverterImpl(helper);
	}

	@Test
	public void testConvert() throws Exception {
		String path = EthloJsonSchema2XsdConverterImplTest.class.getResource("/json/physician.json").getPath();
		Path jsonSchemaPath = Paths.get(path);
		Reader jsonReader = Files.newBufferedReader(jsonSchemaPath, Charset.forName("UTF-8"));
		converter.convert(jsonReader, System.out, "http://myphysician.ns", "physician");
	}

	@Test
	public void testConvert2() throws Exception {
		String path = EthloJsonSchema2XsdConverterImplTest.class.getResource("/json/physician2.json").getPath();
		Path jsonSchemaPath = Paths.get(path);
		Reader jsonReader = Files.newBufferedReader(jsonSchemaPath, Charset.forName("UTF-8"));
		converter.convert(jsonReader, System.out, "http://myphysician.ns", "physician");
	}

}
