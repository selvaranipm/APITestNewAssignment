package com.org.util;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class prestepscls {
	
	static String id = null; 

	public String presteps() 
	{
	// String baseURI="https://api.jsonbin.io/v3/b";
		if (id == null) {
	 JSONObject json=new JSONObject();
	  json.put("sample","Hello universe");
	  
		//RestAssured.baseURI=baseURI;
		Response response=RestAssured.given()
						.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
						.header("X-Bin-Private","false")
						.contentType("application/json")
						.body(json.toString())
						.post();
		
		JsonPath js=response.jsonPath();
		id=js.get("metadata.id");
		System.out.println(id);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		}
		return id;
	}
	
}
