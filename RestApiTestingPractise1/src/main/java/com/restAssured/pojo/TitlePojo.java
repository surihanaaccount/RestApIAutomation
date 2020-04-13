package com.restAssured.pojo;

public class TitlePojo {
	
	 String title;
	
	 String body;
	 
	 String userId;
	 
	 String id;
	
	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {

		return "The title is "+this.title+" body is "+this.body+"user id is "+this.userId;
	}

	public TitlePojo() {
		super();
		
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public TitlePojo(String title, String body, String userId) {
		super();
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	
	
	

}
