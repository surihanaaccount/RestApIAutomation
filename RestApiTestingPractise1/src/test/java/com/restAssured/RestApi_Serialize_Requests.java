package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restAssured.pojo.TitlePojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApi_Serialize_Requests {
	
	@Test
	public void createSerialzeTitle()
	{
		
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
        TitlePojo requestBody=new TitlePojo("tammy","5000","1");
		
		try {
			response = RestAssured.given()
					  .contentType(ContentType.JSON)
					  .body(requestBody)
					  .when().post("/posts");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(201, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void getDeserializeTitle()
	{
		TitlePojo tp=RestAssured.get("https://jsonplaceholder.typicode.com/posts/95").as(TitlePojo.class);
		
		System.out.println(tp.toString());
	}

	
	
}
