package com.mogikanensoftware.json.schema.convert.impl;

import java.io.OutputStream;
import java.io.Reader;

import org.w3c.dom.Document;

import com.ethlo.schematools.jsons2xsd.Jsons2Xsd;
import com.ethlo.schematools.jsons2xsd.Jsons2Xsd.OuterWrapping;
import com.mogikanensoftware.json.schema.convert.ConverterException;
import com.mogikanensoftware.json.schema.convert.JsonSchema2XsdConverter;
import com.mogikanensoftware.json.schema.convert.XMLHelper;

public class EthloJsonSchema2XsdConverterImpl implements JsonSchema2XsdConverter {

	private XMLHelper xmlHelper = null;

	public EthloJsonSchema2XsdConverterImpl(XMLHelper xmlHelper) {
		this.xmlHelper = xmlHelper;
	}

	@Override
	public void convert(final Reader jsonSchema, final OutputStream xsdFileOut, final String targetNameSpaceUri, final String targetTypeName)
			throws ConverterException {
		try {
			final OuterWrapping wrapping = OuterWrapping.TYPE;
			final Document xsdDocument = Jsons2Xsd.convert(jsonSchema, targetNameSpaceUri, wrapping, targetTypeName);
			xmlHelper.saveXMLDomDocument(xsdDocument, xsdFileOut);

		} catch (Exception e) {
			throw new ConverterException(e.getMessage(), e);
		}

	}

}
