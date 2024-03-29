package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
public class Utils {
	
	public static RequestSpecification req;
	public RequestSpecification reqSpec() throws FileNotFoundException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().headers().query
		
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
		req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}

}
