package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApi_Auth_Requests {
	
	@Test(priority=1)
	public void getCustomerDetails()
	{
		RestAssured.baseURI="https://gorest.co.in/public-api";
		
		Response response = null;
		
		try {
			
			response =RestAssured.given()
				      .contentType(ContentType.JSON)
				      .header("authorization", "Bearer YVcLgu6ozth6dboEdVmX8kpWaPMO0zvNOcf8")
					  .when().get("/users");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The response code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
			
			
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//https://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22
	
	@Test(priority=2)
	public void getMapLongitudeDetails()
	{
		RestAssured.baseURI="https://samples.openweathermap.org";
		
		RestAssured.basePath="/data/2.5";
		
		Response response = null;
		
		try
		{
			response = RestAssured.given()
					   .param("q", "London")
					   .param("appid", "b6907d289e10d714a6e88b30761fae22")
					   .when().get("/weather");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The reponse code is "+ response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//https://gorest.co.in/public-api/users?_format=json&access-token=YVcLgu6ozth6dboEdVmX8kpWaPMO0zvNO
	
	@Test(priority=3)
	public void getPublicUsers()
	{
		RestAssured.baseURI="https://gorest.co.in";
		
		RestAssured.basePath="/public-api";
		
		Response response = null;
		
		try {
			
			response = RestAssured.given()
					   .param("_format","json")
					   .param("access-token", "YVcLgu6ozth6dboEdVmX8kpWaPMO0zvNO")
					   .when().get("/users");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The response code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
