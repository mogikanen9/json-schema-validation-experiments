package com.mogikanensoftware.json.schema.convert;

import java.io.OutputStream;

import org.w3c.dom.Document;

public interface XMLHelper {

	void print(final Document xsdDocument, final OutputStream out) throws XMLHelperException;
}
