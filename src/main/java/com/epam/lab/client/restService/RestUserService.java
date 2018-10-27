package com.epam.lab.client.restService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.client.clients.RestUserClient;
import com.epam.lab.client.responses.restResponse.RestResponse;
import com.jayway.restassured.response.Header;

public class RestUserService {
	private static final Logger LOGGER = LogManager.getLogger(RestUserService.class);
	private final String REQUEST_MESSAGE = "Sending %s response with credentials: %s, %s";
	private final String ROLE_MESSAGE = " (role = '%s')";
	private final String SEARCHED_USER_NAME_MESSAGE = " (searchedName = '%s')";
	private final String AUTHENTICATE_REQUEST = "/authenticate";
	private final String GET_USERS_BY_ROLE_REQUEST = "/getUser/%s";
	private final String DELETE_USER_REQUEST = "/deleteUser/%s";
	private final String GET_ALL_USERS_REQUEST = "/getAllUsers";
	private final String AUTHORIZE_REQUEST = "/authorize";
	private RestUserClient restUserClient;
	private Header[] headers;

	public RestUserService() {
		headers = new Header[] {};
		restUserClient = new RestUserClient();
	}

	public RestUserService(String userName, String password) {
		headers = new Header[] { new Header("userName", userName), new Header("password", password) };
		restUserClient = new RestUserClient();
	}

	public RestResponse authenticate(String userName, String password) {
		LOGGER.info(String.format(REQUEST_MESSAGE, AUTHENTICATE_REQUEST, userName, password));
		setCredentials(userName, password);
		return new RestResponse(restUserClient.get(AUTHENTICATE_REQUEST, headers));
	}

	public RestResponse getUsersByRole(String userName, String password, String role) {
		LOGGER.info(String.format(REQUEST_MESSAGE + ROLE_MESSAGE, GET_USERS_BY_ROLE_REQUEST, userName, password, role));
		setCredentials(userName, password);
		return new RestResponse(restUserClient.get(String.format(GET_USERS_BY_ROLE_REQUEST, role), headers));
	}

	public RestResponse deleteUser(String userName, String password, String name) {
		LOGGER.info(String.format(REQUEST_MESSAGE + SEARCHED_USER_NAME_MESSAGE, DELETE_USER_REQUEST, userName, password,
				name));
		setCredentials(userName, password);
		return new RestResponse(restUserClient.delete(String.format(DELETE_USER_REQUEST, name), headers));
	}

	public RestResponse getAllUsers(String userName, String password) {
		LOGGER.info(String.format(REQUEST_MESSAGE, GET_ALL_USERS_REQUEST, userName, password));
		setCredentials(userName, password);
		return new RestResponse(restUserClient.get(GET_ALL_USERS_REQUEST, headers));
	}

	public RestResponse authorize(String userName, String password) {
		LOGGER.info(String.format(REQUEST_MESSAGE, AUTHORIZE_REQUEST, userName, password));
		setCredentials(userName, password);
		return new RestResponse(restUserClient.get(AUTHORIZE_REQUEST, headers));
	}

	public void setCredentials(String userName, String password) {
		headers = new Header[] { new Header("userName", userName), new Header("password", password) };
	}

}
