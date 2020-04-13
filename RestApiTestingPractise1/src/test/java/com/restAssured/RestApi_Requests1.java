package com.restAssured;


import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApi_Requests1 {
	
	@Test(priority=1)
	public void getAllTitlesList()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
		try {
			response=RestAssured.given()
					.when().get("/posts");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			Assert.assertEquals(200, response.getStatusCode());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void getTitle()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
		try {
			response = RestAssured.given()
					   .when().get("/posts/95");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void createTitle()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
		String requestBody = "{\n" +
	            "  \"title\": \"title yoo1\",\n" +
	            "  \"body\": \"Title bar\",\n" +
	            "  \"userId\": \"1\"\n" +
	            "}";
		
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
	
	
	@Test(priority=4,enabled=true)
	public void getTitleById()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
		try {
			response = RestAssured.given()
					   .when().get("/posts/96");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is  "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Important: the resource will not be really created on the server but it will be faked as if. In other words, if you try to access a post using 101 as an id, you'll get a 404 error.
	
	
	@Test(enabled=true,priority =5)
	public void updateTitle()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
		String requestBody="{\n" + 
				"\"id\":\"95\",\n"+
				"\"title\":\"title yooooo\",\n" + 
				"\"body\": \"Title bar Yoo\",\n" + 
				"\"userId\":\"1\"\n" + 
				"}";
		
		try {
			response = RestAssured.given()
					   .contentType("application/json; charset=UTF-8")
					   .body(requestBody)
					   .put("/posts/96");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	@Test(priority=6)
	public void getQueryTitles()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response = null;
		
		String id ="95";
		
		try {
			response =RestAssured.given()
					  .when().get("/posts?id="+id);
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=7)
	public void getPathTitles()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response = null;
		
		String id ="2";
		
		try {
			System.out.println("/posts/"+id+"/id");
			response =RestAssured.given()
					  .when().get("/posts/"+id+"/id");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=8)
	public void getPathComments()
	{
       RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response = null;
		
		try {
			
			response =RestAssured.given()
					  .when().get("/posts/1/comments");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=8)
	public void getQueryComments()
	{
		
     RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response = null;
		
		try {
			
			response =RestAssured.given()
					  .when().get("/comments?postId=1");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			Assert.assertEquals(200, response.getStatusCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=10)
	public void getCommentsFromResponse()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response = null;
		
		String response1;
		
		JSONParser parser = new JSONParser();
		JSONObject json ;

		
		
		try {
			response=RestAssured.given()
					.when().get("/posts/95");
			
			System.out.println("The response is "+response.asString());
			System.out.println("The status code is "+response.getStatusCode());
			
			json= (JSONObject) parser.parse(response.asString());
			
			System.out.println(json.get("title"));


	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=11)
	public void getCommentsLists()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response=null;
		
		JSONParser parser=new JSONParser();
		
		JSONObject json;
		
		try {
			
			response=RestAssured.given()
					.when().get("/posts");
			
			System.out.println("The response is "+response.asString());
			
			System.out.println("The status code is "+response.getStatusCode());
			
			json=(JSONObject) parser.parse(response.asString());
			
			JSONArray comments=(JSONArray)json.get("title");
			
			Iterator<String> iterator = comments.iterator();
			
            while (iterator.hasNext()) {
            	
                System.out.println(iterator.next());
            }
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	

}
