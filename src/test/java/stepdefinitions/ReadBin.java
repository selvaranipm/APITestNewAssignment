package stepdefinitions;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ReadBin {
	
	static Response response=null;
	static String basePath=null;
	static String id=null;
	
	@Given("^the ReadBin URl$")
	public void the_ReadBin_URl() throws Throwable {
		//basePath="https://api.jsonbin.io/v3/b";
		RestAssured.basePath=basePath;
 		RestAssured.basePath=HookUps.id;
		 
	}

	@When("^I send a readget request$")
	public void i_send_a_readget_request() throws Throwable {
		
		System.out.println(HookUps.id);
		  response=RestAssured.given()
					.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
					.get();
	}


	@Then("^verify the Bin is read$")
	public void verify_the_Bin_is_read() throws Throwable {
		
 		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 			
 		
	}

   @Then("^ReadBin status code should be success$")
	public void ReadBin_status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		assertEquals(response.getStatusCode(), 200);
	} 

}
