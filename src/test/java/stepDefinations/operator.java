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

public class operator extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();

	@Given("Operator key with {string} {string} {string} {string} {string} {string} {string}   {string} {string} {string} {string}{string} {string}")
	public void operator_key_with(String csaKeyVersionNo, String exponent, String appVersionNumber, String idsBinVersionNo, String modulus, String merchantID, String osaKeyVersionNo, String processingCode, String posSerialNumber,String reqId, String stan, String terminalId, String idsKeyVersionNo) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification("operatorkey"))
				.body(data.operatorPayload(appVersionNumber, csaKeyVersionNo, exponent, idsBinVersionNo, idsKeyVersionNo, merchantID, modulus, osaKeyVersionNo, posSerialNumber, processingCode, reqId, stan, terminalId));
	}
	@When("user calls Operator key {string} with {string} http request")
	public void user_calls_operator_key_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
	}
	@Then("the Operator key API call got success with status code {int}")
	public void the_operator_key_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(int1);
		Integer int2=response.getStatusCode();
		Assert.assertEquals(int1,int2);
       
	}
	@Then("{string} in Operator key response body is {string}")
	public void in_operator_key_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}

}
