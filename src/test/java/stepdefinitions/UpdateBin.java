package stepdefinitions;

import org.json.JSONObject;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class UpdateBin {
	
	static Response response=null;
	static String basePath=null;
	static String privacy=null;
	
	@Given("^the updateBin URl$")
	public void the_updateBin_URl() throws Throwable {
		System.out.println(HookUps.id);
		//basePath="https://api.jsonbin.io/v3/b";
		RestAssured.basePath=basePath; 
		RestAssured.basePath=HookUps.id;
	}

	@When("^I send a updateput request$")
	public void i_send_a_updateput_request() throws Throwable {
		  JSONObject json=new JSONObject();
		  json.put("sample","Hello universe");
		 
		  response=RestAssured.given()
					.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
					.header("X-Bin-Private","false")
					.contentType("application/json")
					.body(json.toString())
					.put();
	}


	@Then("^verify the updateBin is updated$")
	public void verify_the_updateBin_is_updated() throws Throwable {
		JsonPath js=response.jsonPath();
		privacy=js.get("metadata.private");
 		System.out.println(privacy);
 		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		
	}

	/* @Then("^status code should be success$")
	public void status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		assertEquals(response.getStatusCode(), 200);
	} */

}
