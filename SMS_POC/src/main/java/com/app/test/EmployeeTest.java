package com.app.test;

/*import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.app.configuration.AppConfig;
import com.app.pojos.Employee;
import com.app.service.EmployeeService;

*/
/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
public class EmployeeTest {

	private MockMvc mockmvc;
	
	@Autowired
	public WebApplicationContext webApplicationContext;
	
	@Autowired
	public EmployeeService employeeServiceMock;
	
	@Before
	public void setUp(){
	        mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void checkEmployeeList() throws Exception{
		Employee emp=new Employee(6, "Rahul", "Java", "Abc", "pending");
		List<Employee> emps=new ArrayList<>();
		emps.add(new Employee(6, "Rahul", "Java", "Abc", "pending"));
		System.out.println(employeeServiceMock.searchById(6));
		
		//when(employeeServiceMock.searchById(6)).thenReturn(emp);
		
		//mockmvc.perform(get("/employee/search")).andExpect(view().name("/employeeView/home"));
		mockmvc.perform(get("/employee/search")).andExpect(ResultMatcher.matchAll(view().name("/employeeView/home"), model().attributeExists("employee")))
				.andExpect(model().attribute("employee", emp)).andReturn();
		
		
	}
	
}
*/