package stepDefinations;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;

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

public class ParameterDef extends Utils{
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	

	@Given("ParamDownload with {string},{string},{string},{string},{string},{string},{string},{string}")
	public void ParamDownload_with(String appVersionNumber, String batchNumber, String merchantID, String PosSerialNumber, String ProcessingCode, String ReqId, String Stan, String TerminalId) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification("Param"))
				.body(data.parameterPayload(appVersionNumber, batchNumber, merchantID, PosSerialNumber, ProcessingCode, ReqId, Stan, TerminalId));
	}
	
	@When("user calls param {string} with {string} http request")
	public void user_calls_param_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
	    
	}
	@Then("the param API call got success with status code {int}")
	public void the_param_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(int1);
		Integer int2=response.getStatusCode();
		Assert.assertEquals(int1,int2);
	   
	}

	@Then("{string} in param dowload response body is {string}")
	public void in_param_dowload_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("param download response  message is {string} for {string}")
	public void param_download_response_message_is_for(String message, String c) {
	    // Write code here that turns the phrase above into concrete actions
		Boolean boolean1 = Boolean.valueOf(c);
		
    	if (boolean1) {
    		if(getJsonPath(response,"payload.responseCode")=="00") {
//		  Assert.assertEquals(message, getJsonPath(response,"payload.field63"));
    			}
		} else {
		  Assert.assertEquals(message, getJsonPath(response,"errors.message"));
		}
	    
	}
	@Then("param download response code is {string} for {string}")
	public void param_download_response_code_is_for(String rc, String c) {
	    // Write code here that turns the phrase above into concrete actions
		Boolean boolean1 = Boolean.valueOf(c);
    	if (boolean1) {	
    	System.out.println(rc);	
		  Assert.assertEquals(rc, getJsonPath(response,"payload.responseCode"));
	}
	}



}
