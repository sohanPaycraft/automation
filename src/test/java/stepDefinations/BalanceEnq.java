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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class BalanceEnq extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	@Given("Balance enquiry with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}{string} {string}")
	public void balance_enquiry_with(String ChipData, String amount, String appVersionNumber, String batchNumber, String invoiceNumber, String merchantID, String merchantNameLoc, String nii, String posEntryMode, String posSerialNumber, String processingCode, String reqId, String stan, String terminalId, String track2Data) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification("BalnceEnquiry"))
				.body(data.bePayload(ChipData, amount, appVersionNumber, batchNumber, invoiceNumber, merchantID, merchantNameLoc, nii, posEntryMode, posSerialNumber, processingCode, reqId, stan, terminalId, track2Data));
	}
	@When("user calls BalEnq {string} with {string} http request")
	public void user_calls_bal_enq_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
	}
	@Then("the BalEnq API call got success with status code {int}")
	public void the_bal_enq_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(int1);
		Integer int2=response.getStatusCode();
		Assert.assertEquals(int1,int2);
       
	    
	}
	@Then("{string} in Bal response body is {string}")
	public void in_bal_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response,keyValue),Expectedvalue);
		
	}
	@Then("check if response contains RRN, chip-balance,total-balance for {string} and status is {string}")
	public void check_if_response_contains_rrn_chip_balance_total_balance_for_and_status_is(String rc, String status) {
	    // Write code here that turns the phrase above into concrete actions
		if(status.matches("200")) {
		if(rc.matches("00"))
		{
			Assert.assertTrue(de55(getJsonPath(response,"payload.field55Data")));
	        Assert.assertTrue(amount(getJsonPath(response,"payload.chip-balance")));
	        Assert.assertTrue(amount(getJsonPath(response,"payload.total-balance")));
	        Assert.assertTrue(amount(getJsonPath(response,"payload.rrn"))); 	
		}else {
			Assert.assertEquals((getJsonPath(response,"payload.approvalCode")), null);
			Assert.assertEquals((getJsonPath(response,"payload.chip-balance")), null);
			Assert.assertEquals((getJsonPath(response,"total-balance")), null);
			Assert.assertEquals((getJsonPath(response,"offlineBalSign")), null);
			Assert.assertEquals((getJsonPath(response,"rrn")), null);
			Assert.assertEquals((getJsonPath(response,"payload.onlineBalSign")), null);
		}
		}
	}

	
	@Then("response message for balance enq is {string} for {string}")
	public void response_message_for_balance_enq_is_for(String message, String c) {
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
	@Then("response code for baane enq is {string} for {string}")
	public void response_code_for_baane_enq_is_for(String rc, String c) {
		Boolean boolean1 = Boolean.valueOf(c);
    	if (boolean1) {	
    	System.out.println(rc);	
		  Assert.assertEquals(rc, getJsonPath(response,"payload.responseCode"));
	}
}
	
}