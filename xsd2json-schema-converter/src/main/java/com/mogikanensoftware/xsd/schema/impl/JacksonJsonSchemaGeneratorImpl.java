package com.mogikanensoftware.xsd.schema.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.mogikanensoftware.xsd.schema.JsonSchemaGenerator;
import com.mogikanensoftware.xsd.schema.JsonSchemaGeneratorException;

public class JacksonJsonSchemaGeneratorImpl implements JsonSchemaGenerator {

	private ObjectMapper objectMapper = null;
	
	public JacksonJsonSchemaGeneratorImpl(){
		this.init();
	}
	
	protected void init() {
		objectMapper = new ObjectMapper();
		final TypeFactory typeFactory = TypeFactory.defaultInstance();
		final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(typeFactory);
		// make deserializer use JAXB annotations (only)
		objectMapper.getDeserializationConfig().with(introspector);
		// make serializer use JAXB annotations (only)
		objectMapper.getSerializationConfig().with(introspector);
		
	}

	public void generate(final String fullyQualifiedClassName, OutputStream out) throws JsonSchemaGeneratorException {
		
		final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.acceptJsonFormatVisitor(mapper.constructType(Class.forName(fullyQualifiedClassName)), visitor);
			final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
			out.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema)
					.getBytes(Charset.forName("UTF-8")));
		} catch (ClassNotFoundException cnfEx) {
			throw new JsonSchemaGeneratorException("Unable to find class " + fullyQualifiedClassName, cnfEx);
		} catch (JsonMappingException jsonEx) {
			throw new JsonSchemaGeneratorException("Unable to map JSON :" + jsonEx.getMessage(), jsonEx);
		} catch (JsonProcessingException jsonEx) {
			throw new JsonSchemaGeneratorException("Unable to process JSON: " + jsonEx.getMessage(), jsonEx);
		}catch (IOException ioex){
			throw new JsonSchemaGeneratorException(ioex.getMessage(),ioex);
		}
	}
}
