package com.epam.lab.client.responses.restResponse;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.client.models.Role;
import com.epam.lab.client.models.User;
import com.jayway.restassured.response.Response;

public class RestResponse {
	private static final Logger LOGGER = LogManager.getLogger(RestResponse.class);
	private final String STATUS_CODE_MESSAGE = "Server status code: %s";
	private final String RESPONSE_MESSAGE = "REST response message: %s";
	private final String USERS_MESSAGE = "REST response users: %s";
	private final String ROLES_MESSAGE = "REST response roles: %s";

	private Response response;

	public RestResponse(Response response) {
		this.response = response;
	}

	public String getMessage() {
		LOGGER.info(String.format(RESPONSE_MESSAGE, response.getBody().asString()));
		return response.getBody().asString();
	}

	public List<Role> getRoles() {
		LOGGER.info(String.format(ROLES_MESSAGE, response.getBody().asString()));
		return Arrays.asList(response.getBody().as(Role[].class));
	}

	public List<User> getUser() {
		LOGGER.info(String.format(USERS_MESSAGE, response.getBody().asString()));
		return Arrays.asList(response.getBody().as(User[].class));
	}

	public int getStatusCode() {
		LOGGER.info(String.format(STATUS_CODE_MESSAGE, response.getStatusCode()));
		return response.getStatusCode();
	}
}
