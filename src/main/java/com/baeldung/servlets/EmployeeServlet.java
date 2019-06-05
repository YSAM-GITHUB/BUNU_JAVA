package com.baeldung.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.baeldung.model.Employee;
import com.google.gson.Gson;


@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private Gson gson = new Gson();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		try{
		Employee employee = new Employee(1, "Karan", "IT", 5000);
		String employeeJsonString = this.gson.toJson(employee);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("employeejson", employeeJsonString);
		
		
		//out.print(employeeJsonString);
		//out.print(response.getHeader("employeejson").toString());
		//out.flush();   
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/testIndex.jsp");
        dispatcher.forward(request, response);
	}
		catch(Exception e)
		{
			response.sendRedirect("index.jsp");
		}

 }
}