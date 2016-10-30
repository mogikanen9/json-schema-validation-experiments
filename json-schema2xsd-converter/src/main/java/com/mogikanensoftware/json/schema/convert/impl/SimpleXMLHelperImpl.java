package com.mogikanensoftware.json.schema.convert.impl;

import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.mogikanensoftware.json.schema.convert.XMLHelper;
import com.mogikanensoftware.json.schema.convert.XMLHelperException;

public class SimpleXMLHelperImpl implements XMLHelper {
	
	public void saveXMLDomDocument(final Document xsdDocument, final OutputStream out) throws XMLHelperException {
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.transform(new DOMSource(xsdDocument), new StreamResult(out));

		} catch (Exception ex) {
			throw new XMLHelperException(ex.getMessage(), ex);
		}
	}
}
