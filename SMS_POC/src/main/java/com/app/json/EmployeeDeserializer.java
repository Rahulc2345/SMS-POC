package com.app.json;

import java.io.IOException;

import com.app.pojos.Employee;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

/*public class EmployeeDeserializer extends StdDeserializer<Employee>{


    public EmployeeDeserializer() { 
        this(null); 
    } 
 
    public EmployeeDeserializer(Class<?> e) { 
        super(e); 
    }
	
	@Override
	public Employee deserialize(JsonParser jp, DeserializationContext descontext)
			throws IOException, JsonProcessingException {
		JsonNode node= jp.getCodec().readTree(jp);
		int id=(Integer) ((IntNode) node.get("id")).numberValue();
		String name = node.get("name").asText();
		String assignedBy = node.get("assignedBy").asText();
		String task = node.get("task").asText();
		String status = node.get("status").asText();
		return new Employee(id, name, task, assignedBy, status);
	}
	

}*/
