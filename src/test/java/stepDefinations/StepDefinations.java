package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinations extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();

	@Given("logon with {string} {string} {string} {string} {string} {string} {string} {string}")
	public void logon_with(String appVersionNumber, String merchantID, String merchantNameLoc, String posSerialNumber, String processingCode, String reqId, String stan, String terminalId) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification("Login"))
				.body(data.logonPayload(appVersionNumber, merchantID, merchantNameLoc, posSerialNumber, processingCode, reqId, stan, terminalId));
	    
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
	    
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(int1);
		Integer int2=response.getStatusCode();
		Assert.assertEquals(int1,int2);
	   
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	   
	}
	@Then("response message is {string} for {string}")
	public void response_message_is_for(String message, String c) {
	    // Write code here that turns the phrase above into concrete actions
		Boolean boolean1 = Boolean.valueOf(c);
		
    	if (boolean1) {
    		if(getJsonPath(response,"payload.responseCode")=="00") {
		  Assert.assertEquals(message, getJsonPath(response,"payload.field63"));}
		} else {
		  Assert.assertEquals(message, getJsonPath(response,"errors.message"));
		}
	}
	
	@Then("response code is {string} for {string}")
	public void response_code_is_for(String rc, String c) {
	    // Write code here that turns the phrase above into concrete actions
		Boolean boolean1 = Boolean.valueOf(c);
    	if (boolean1) {	
    	System.out.println(rc);	
		  Assert.assertEquals(rc, getJsonPath(response,"payload.responseCode"));
		} 
	}

	
	


	
	




}
