package com.app.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.sql.ordering.antlr.SortSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;


public class ObjectMapperTest {

	@Autowired
	EmployeeService employeeService;
	JsonNode rootNode;
  
	ObjectMapper mapper=new ObjectMapper();
	HashMap<String, Employee> hm=new LinkedHashMap<>();
	
	public void putEmployeeInfo(Employee e) throws Exception{
		//Employee e=employeeService.searchById(id);
		/*Employee emp=new Employee();
		emp.setId(e.getId());
		emp.setName(e.getName());
		emp.setStatus(e.getStatus());
		emp.setAssignedBy(e.getAssignedBy());
		emp.setTask(e.getTask());*/
		
		System.out.println("in put emp");
		//mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\rahul.chaurasia\\poc_workspace\\POC_Project\\test.json"), e);    // write values to file, without appending
		
        System.out.println(e);
	}
	
	public void appendEmployeeInFile(List<Employee> employeeList) throws IOException{
		File file=new File("C:\\Users\\rahul.chaurasia\\poc_workspace\\POC_Project\\test1.json");     
		
		/*
		 * FileWriter writer=new FileWriter(file,true);
		mapper.writerWithDefaultPrettyPrinter().writeValuesAsArray(writer).write(e);   //  append--  Here, write is the method of Sequence Writer
	
        SequenceWriter sequence = mapper.writer().writeValuesAsArray(writer);				
        sequence.write(e);
		*/
        
        /*try {
			JsonGenerator generator = mapper.getFactory().createGenerator(new FileWriter(file, true));
			mapper.writeValue(generator, employeeList);
			generator.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}*/

		mapper.writerWithDefaultPrettyPrinter().writeValue(file, employeeList);
	}
	
	public void readJson(){
		System.out.println("in read");
		
		try{
			Employee e=mapper.readValue(new File("C:\\Users\\rahul.chaurasia\\poc_workspace\\POC_Project\\test1.json"), Employee.class);
			System.out.println("Employeesssss "+e);
		}
		catch(Exception ex){
			System.out.println(ex.getLocalizedMessage());
		}
		
		boolean a=mapper.canSerialize(Employee.class);
		System.out.println(a);
		/*
		try{
			e=mapper.readValue(rootNode.toString(), Employee.class);
			hm = mapper.readValue(new File("F:\\test.json"),
					new TypeReference<Map<String,Employee>>() {
					});
			
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
		
		//System.out.println(e);
		
	}
	
	public void readJsonArray(){
		System.out.println("in json array");
		List<Employee> employeelist=null;
		
		try {
			employeelist= mapper.readValue(new File("C:\\Users\\rahul.chaurasia\\poc_workspace\\POC_Project\\test1.json"), 
					new TypeReference<List<Employee>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(employeelist);
	}
}
