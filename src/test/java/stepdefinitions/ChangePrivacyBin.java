package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;

import com.org.util.prestepscls;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ChangePrivacyBin {
	
	static Response response=null;
	static String basePath=null;
	static String id=null;
	static Boolean privacy=null;
	static String finalpath=null;
	static String js=null;
	
	
	@Given("^the CPendpoint URl$")
	public void the_endpoint_URl() throws Throwable {
		//basePath="https://api.jsonbin.io/v3/b/607c9356ee971419c4dc7984/meta/privacy";
		prestepscls p = new prestepscls();
		String id = p.presteps();
		
		//String id = prestepscls.presteps();
		System.out.println("id = " +id);
	//	System.out.println("basepath = " +basePath);
		//RestAssured.basePath=basePath; 
		//RestAssured.basePath=HookUps.id;
		//RestAssured.basePath=id;
		String baseURI="https://api.jsonbin.io/v3/b";
		RestAssured.baseURI=baseURI;
		RestAssured.basePath=id+"/meta/privacy";
		System.out.println(id+"/meta/privacy");
		
	}

	@When("^I send a chnageprivacyput request$")
	public void i_send_a_chnageprivacyput_request() throws Throwable {
		//System.out.println(HookUps.id);
		JSONObject json=new JSONObject();
		 json.put("sample","Hello worldies");
	  
		//RestAssured.baseURI=basePath;
		//RestAssured.basePath=id;
		response=RestAssured.given()
						.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
						.header("X-Bin-Private","true")
						.contentType("application/json")
						.body(json.toString())
						.put();
		
	}


	@Then("^verify the changeprivacyBin is updated$")
	public void verify_the_changeprivacyBin_is_updated() throws Throwable {
		//System.out.println(HookUps.id);
		JsonPath js=response.jsonPath();
		privacy=js.get("metadata.private");
 		System.out.println(privacy);
 		 		
	}

	 @Then("^verify CP status code should be success$")
	public void verify_CP_status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		assertEquals(response.getStatusCode(), 200);
 		System.out.println("ChangePrivacy");
	} 

}
