package com.epam.lab.client;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.lab.client.models.Role;
import com.epam.lab.client.models.User;
import com.epam.lab.client.responses.soapResponse.ResponseMessage;
import com.epam.lab.client.responses.soapResponse.SoapResponse;
import com.epam.lab.client.soapService.SoapUserService;
import com.epam.lab.client.soapService.SoapUserServiceImplService;
import com.epam.lab.client.utils.CSVParser;
import com.epam.lab.client.utils.PropertyParser;

public class SoapUserServiceTest {
	private final String PROPERTIES_PATH = "src/test/resources/com/epam/lab/client/config.properties";
	private final String RIGHT_CREDENTIALS_PROPERTY = "rightCredentialsPath";
	private final String WRONG_CREDENTIALS_PROPERTY = "wrongCredentialsPath";
	private final String USERS_BASE_PROPERTY = "usersBasePath";
	private final String CREDENTIALS_USER_ROLE_PROPERTY = "credentialUserRole";
	private final String USER_TO_DELETE = "user9";
	private PropertyParser properies;
	private SoapUserService soapUserService;

	@BeforeClass
	public void serviceSetup() {
		SoapUserServiceImplService soapServiceService = new SoapUserServiceImplService();
		soapUserService = soapServiceService.getSoapUserServiceImplPort();
		properies = new PropertyParser(PROPERTIES_PATH);
	}

	@Test
	public void authenticateRightCredentialsTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		SoapResponse response = soapUserService.authenticate(user.getUserName(), user.getPassword());
		Assert.assertEquals(response.getMessage(), ResponseMessage.AUTHENTICATION_SUCCESS);
	}

	@Test
	public void authenticateWrongCredentialsTest() {
		User user = CSVParser.getUser(properies.getProperty(WRONG_CREDENTIALS_PROPERTY));
		SoapResponse response = soapUserService.authenticate(user.getUserName(), user.getPassword());
		Assert.assertEquals(response.getMessage(), ResponseMessage.INVALID_CREDENTIALS);
	}

	@Test
	public void wrongRoleGetAllUsersTest() {
		User user = CSVParser.getUser(properies.getProperty(CREDENTIALS_USER_ROLE_PROPERTY));
		SoapResponse response = soapUserService.getAllUsers(user.getUserName(), user.getPassword());
		Assert.assertEquals(response.getMessage(), ResponseMessage.FORBIDDEN_OPERATION);
	}

	@Test
	public void getUsersByRoleTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		SoapResponse response = soapUserService.getUsersByRole(user.getUserName(), user.getPassword(),
				Role.USER.toString());
		Assert.assertEquals(response.getUser(),
				CSVParser.getUsersByRole(properies.getProperty(USERS_BASE_PROPERTY), Role.USER.toString()));
	}

	@Test
	public void removeWrongUserTest() {
		User user = CSVParser.getUser(properies.getProperty(RIGHT_CREDENTIALS_PROPERTY));
		SoapResponse response = soapUserService.deleteUser(user.getUserName(), user.getPassword(), USER_TO_DELETE);
		Assert.assertEquals(response.getMessage(), ResponseMessage.USER_NOT_FOUND);
	}
}
