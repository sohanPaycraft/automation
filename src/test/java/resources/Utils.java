package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public static String y;
	public RequestSpecification requestSpecification(String x) throws IOException
	{
		if(y==null) {
			y="qq";
		}
		if(req==null||!(y==x))
		{
			y=x;
		PrintStream log =new PrintStream(new FileOutputStream("logging"+x+".txt"));
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\SwitchIntegration\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	
		
		
	}
	public String getJsonPath(Response response,String key) 
	{
		 String resp=response.asString();
		 JsonPath   js = new JsonPath(resp);  
		try{    return js.get(key).toString();
			 
			}catch(NullPointerException ref){return null;}    
		 
		
		
	}
	
	 public boolean amount(String input) {
	        // Compile regular expression
		 	
	        Pattern pattern = Pattern.compile("\\d{12}" ,Pattern.CASE_INSENSITIVE);
	        // Match regex against input
	        Matcher matcher = pattern.matcher(input);
	        // Use results...
	        return matcher.matches();
	    }
	   public boolean de55(String input) {
		   
		   Pattern pattern = Pattern.compile("^911.*$" ,Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(input);
	        return matcher.matches();
			
	    }

}
