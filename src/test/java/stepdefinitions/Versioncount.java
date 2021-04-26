package stepdefinitions;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Versioncount {
	
	static Response response=null;
	static String basePath=null;
	static String id=null;
	
	@Given("^the versioncount URl$")
	public void the_endpoint_URl() throws Throwable {
		//basePath="https://api.jsonbin.io/v3/b/607c9356ee971419c4dc7984/versions/count";
		RestAssured.basePath=basePath;
 		RestAssured.basePath=HookUps.id;
	}

	@When("^I send a countget request$")
	public void i_send_a_get_request() throws Throwable {
		System.out.println(HookUps.id);
		 response=RestAssured.given()
				.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
				.header("X-Bin-Private","true")
			.contentType("application/json")
				.get();
	}


	@Then("^verify the count$")
	public void verify_the_count() throws Throwable {
		JsonPath js=response.jsonPath();
 		id=js.get("metadata.id");
 		System.out.println(id);
 		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		
	}

	/*@Then("^status code should be success$")
	public void status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		assertEquals(response.getStatusCode(), 200);
	} */

	
		

}