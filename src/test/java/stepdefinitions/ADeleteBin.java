package stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.org.util.prestepscls;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ADeleteBin {
	
	static Response response=null;
	static String basePath=null;
	static String id=null;
	static String js=null;
	static String binid=null;
	
	@Given("^the DeleteBin endpoint URl$")
	public void the_DeleteBin_endpoint_URl() throws Throwable {
		prestepscls p = new prestepscls();
		String id = p.presteps();
		System.out.println("id = " +id);
		//System.out.println(HookUps.id);	
		//basePath="https://api.jsonbin.io/v3/b";
		
		RestAssured.basePath=basePath; 
		//RestAssured.basePath=HookUps.id;
		RestAssured.basePath=id;
		/* response=RestAssured.given()
					.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
					.delete(); */
	}

	@When("^I send a Delete request$")
	public void i_send_a_Delete_request() throws Throwable {
	//	System.out.println(HookUps.id);	
		//JSONObject json=new JSONObject();
		 //json.put("sample","Hello worldies");
		
		 response=RestAssured.given()
					.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
					.delete(); 
	}


	@Then("^verify the Bin is Deleted$")
	public void verify_the_Bin_is_Deleted() throws Throwable {
		//JsonPath js=response.jsonPath();
		//JsonPath responseJson = js.convertRawDataToJson(response);
 		//id=js.get("metadata.id");
 		System.out.println(id);
 	//	System.out.println(responseJson);
 		 		
	}

	@Then("^DeleteBin status code should be success$")
	 public void DeleteBin_status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		assertEquals(response.getStatusCode(), 200);
	}


}
