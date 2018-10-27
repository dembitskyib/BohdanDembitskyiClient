package com.epam.lab.client;

import javax.ws.rs.core.Response.Status;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.lab.client.models.Role;
import com.epam.lab.client.models.User;
import com.epam.lab.client.responses.restResponse.RestResponse;
import com.epam.lab.client.restService.RestUserService;
import com.epam.lab.client.utils.CSVParser;
import com.epam.lab.client.utils.PropertyParser;

public class RestUserServiceTest {
	private final String PROPERTIES_PATH = "src/test/resources/com/epam/lab/client/config.properties";
	private final String RIGHT_CREDENTIALS_PROPERTY = "rightCredentialsPath";
	private final String WRONG_CREDENTIALS_PROPERTY = "wrongCredentialsPath";
	private final String USERS_BASE_PROPERTY = "usersBasePath";
	private final String USER_TO_DELETE = "user9";
	private RestUserService restUserService;
	private PropertyParser properies;

	@BeforeClass
	public void serviceSetup() {
		restUserService = new RestUserService();
		properies = new PropertyParser(PROPERTIES_PATH);
	}

	@Test
	public void authorizeRightCredentialsTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		RestResponse response = restUserService.authorize(user.getUserName(), user.getPassword());
		Assert.assertEquals(response.getStatusCode(), Status.OK.getStatusCode());
		Assert.assertEquals(response.getRoles(), user.getRoleList());
	}

	@Test
	public void authorizeWrongCredentialsTest() {
		User user = CSVParser.getUser(properies.getProperty(WRONG_CREDENTIALS_PROPERTY));
		Assert.assertEquals(restUserService.authorize(user.getUserName(), user.getPassword()).getStatusCode(),
				Status.UNAUTHORIZED.getStatusCode());
	}

	@Test
	public void getUsersByRoleTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		RestResponse response = restUserService.getUsersByRole(user.getUserName(), user.getPassword(),
				Role.ADMIN.toString());
		Assert.assertEquals(response.getStatusCode(), Status.OK.getStatusCode());
		Assert.assertEquals(response.getUser(),
				CSVParser.getUsersByRole(properies.getProperty(USERS_BASE_PROPERTY), Role.ADMIN.toString()));
	}

	@Test
	public void getAllUsersTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		RestResponse response = restUserService.getAllUsers(user.getUserName(), user.getPassword());
		Assert.assertEquals(response.getStatusCode(), Status.OK.getStatusCode());
		Assert.assertEquals(response.getUser(), CSVParser.getUsers(properies.getProperty(USERS_BASE_PROPERTY)));
	}

	@Test
	public void removeWrongUserTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		RestResponse response = restUserService.deleteUser(user.getUserName(), user.getPassword(), USER_TO_DELETE);
		Assert.assertEquals(response.getStatusCode(), Status.NOT_FOUND.getStatusCode());
	}

}
