package com.baeldung.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import com.baeldung.model.Student;
import com.baeldung.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FormServletLiveTest {

    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect() throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost method = new HttpPost("http://13.232.77.162:8080/javax-servlets-0.0.1-SNAPSHOT/calculateServlet");

        List<BasicNameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("height", String.valueOf(2)));
        nvps.add(new BasicNameValuePair("weight", String.valueOf(80)));

        method.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse httpResponse = client.execute(method);

        assertEquals("Success", httpResponse.getHeaders("Test")[0].getValue());
        assertEquals("20.0", httpResponse.getHeaders("BMI")[0].getValue());
    }
    
    @Test
    public void testStudentService() throws Exception {

    	StudentService studentService = new StudentService();
    	Optional <Student> student= studentService.getStudent(Integer.parseInt("2"));
    	if(student.isPresent())
    	{
    		//System.out.println(((Student)student.get()).getFirstName());
    		assertEquals("Jane",((Student)student.get()).getFirstName());
    	}
        
    }
    
}
