package com.epam.lab.client.clients;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class RestUserClient {
	private final ContentType DEFAULT_CONTENT_TYPE = ContentType.JSON;
	private final String URI = "http://localhost:8888/BohdanDembitskyiService/restService";
	private RequestSpecification requestSpecification;

	public RestUserClient() {
		requestSpecification = given().baseUri(URI);
	}

	public Response get(String url, Header... headers) {
		return given().spec(requestSpecification).contentType(DEFAULT_CONTENT_TYPE).headers(new Headers(headers)).when()
				.get(url).then().extract().response();

	}

	public Response post(String url, Header... headers) {
		return given().spec(requestSpecification).contentType(DEFAULT_CONTENT_TYPE).headers(new Headers(headers)).when()
				.post(url).then().extract().response();

	}

	public Response delete(String url, Header... headers) {
		return given().spec(requestSpecification).contentType(DEFAULT_CONTENT_TYPE).headers(new Headers(headers)).when()
				.delete(url).then().extract().response();

	}

	public Response put(String url, Header... headers) {
		return given().spec(requestSpecification).contentType(DEFAULT_CONTENT_TYPE).headers(new Headers(headers)).when()
				.put(url).then().extract().response();

	}
}
