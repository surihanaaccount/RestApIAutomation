package com.restAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utils.RestUtils;

import io.restassured.RestAssured;

import com.report.ReportGeneration;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


@Listeners(ReportGeneration.class)	

/* given()
 *        set cookies, add auth, add param, set headers info etc....
 *  when()
 *       all types of request we can set here get,put,post,delete
 *  then()
 *       to validate the response for example validate status code,extract response,extract headers,cookies and response body           
 */


public class RestApi_Get_Request {
	
	public static HashMap map=new HashMap();
	
	public static HashMap map1=new HashMap();
	
	int emp_id=719;
	
	@BeforeClass
	public void postData()
	{
		map.put("FirstName",RestUtils.getFirstName());
		map.put("LastName",RestUtils.getLastName());
		map.put("UserName",RestUtils.getUserName());
		map.put("Password",RestUtils.getPassword());
		map.put("Email",RestUtils.getEmail());
		
		map1.put("name", RestUtils.empName());
		map1.put("empSalary", RestUtils.empSal());
		map1.put("empAge", RestUtils.empAge());
		
		
	}
	
	
	@Test
	public void getWeatherDetails()
	{
		given().
		 when().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		  .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
		  .assertThat().body("City", equalTo("Hyderabad"))
		  .header("Content-Type", "application/json");
	}
	
	
	@Test
	public void createData()
	{
		/*
		 * given().contentType("application/json").basePath("/register").body(map).
		 * when().post("http://restapi.demoqa.com/customer")
		 * .then().statusCode(201).body("SuccessCode", equalTo("Operation_Success"))
		 * .body("Message", equalTo("Operation completed successfully"));
		 */
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
		given().contentType("application/json").body(map).
		 when().post()
		  .then().statusCode(201).body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		  .body("Message", equalTo("Operation completed successfully"));
	}
	
	
	@Test
	public void updateData()
	{
		RestAssured.baseURI="http://dummy.restapiexample/api/v1";
		RestAssured.basePath="/update/"+emp_id;
		
		given().contentType("application/json").body(map1).
		 when().put()
		  .then().statusCode(200);
	}
	
	@Test
	public void deleteData()
	{
		RestAssured.baseURI="http://dummy.restapiexample/api/v1";
		RestAssured.basePath="/delete/"+emp_id;
		
		given().
		 when().delete()
		  .then().statusCode(200);
	}
	
	
	
	
	
	
	

}
