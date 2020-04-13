package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApi_Requests {
	
	@Test(priority=1)
	public void getEmployees()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		Response response =null;
		
		try {
			response =RestAssured.given()
					.when()
					.get("/employees");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			System.out.println("Does response contains employee salary? :"+response.asString().contains("employee_salary"));
	
			Assert.assertEquals(200, response.getStatusCode());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
	
	@Test(priority=2)
	public void createEmployee()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		Response response=null;
		
		String requestBody = "{\n" +
	            "  \"name\": \"tammy\",\n" +
	            "  \"salary\": \"5000\",\n" +
	            "  \"age\": \"20\"\n" +
	            "}";
		
		try {
			response = RestAssured.given().log().ifValidationFails()
					   .contentType(ContentType.JSON)
					   .body(requestBody)
					   .when().post("/create");
			
			System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	        System.out.println("Does Reponse contains 'tammy'? :" + response.asString().contains("tammy"));
	 
	 
	        Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	@Test(priority=3)
	public void updateEmployee()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		Response response=null;
		
		String requestBody = "{\n" +
	            "  \"name\": \"put_test_employee\",\n" +
	            "  \"salary\": \"5125\",\n" +
	            "  \"age\": \"25\"\n" +
	            "}";
		
		try {
			response = RestAssured.given()
					   .contentType(ContentType.JSON)
					   .body(requestBody)
					   .when().put("/update/4710");
			
			System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	        System.out.println("Does Reponse contains 'tammy'? :" + response.asString().contains("tammy"));
	 
	 
	        Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Test(priority=4)
	public void deleteEmployee()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		Response response = null;
		try {
		response = RestAssured.given()
				   .when().delete("/delete/11400");
		
		System.out.println("Response :" + response.asString());
		System.out.println("The status code :"+response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}
}
