package com.baeldung.servlets;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import org.mockito.Mock;


import com.baeldung.model.Employee;
import com.google.gson.Gson;

public class EmployeeServletIntegrationTest {

	@Mock
	HttpServletRequest httpServletRequest;

	@Mock
	HttpServletResponse httpServletResponse;

	Employee employee;

	@Test
	public void employeeReturnedAsJson() throws Exception {

		//Given
		int id = 1;
		String name = "Karan Khanna";
		String department = "IT";
		long salary = 5000;
		employee = new Employee(id, name, department, salary);
		
		HttpClient client = HttpClientBuilder.create().build();
        HttpGet method = new HttpGet("http://localhost:8080/javax-servlets-0.0.1-SNAPSHOT/employeeServlet");
        HttpResponse httpResponse = client.execute(method);
        
        //System.out.println(((Header)httpResponse.getHeaders("employeejson")[0]).getValue());
        String employeeJsonString = ((Header)httpResponse.getHeaders("employeejson")[0]).getValue();
        Employee fetchedEmployee = new Gson().fromJson(employeeJsonString, Employee.class);
		
		assertEquals(fetchedEmployee, employee);
	} 

}