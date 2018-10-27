
package com.epam.lab.client.soapService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.epam.lab.client.responses.soapResponse.SoapResponse;

@WebService(name = "SoapUserService", targetNamespace = "http://soap.service.lab.epam.com/")
@XmlSeeAlso({ ObjectFactory.class })
public interface SoapUserService {

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "authenticate", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.Authenticate")
	@ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.AuthenticateResponse")
	public SoapResponse authenticate(@WebParam(name = "userName", targetNamespace = "") String userName,
			@WebParam(name = "password", targetNamespace = "") String password);

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getUsersByRole", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.GetUsersByRole")
	@ResponseWrapper(localName = "getUsersByRoleResponse", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.GetUsersByRoleResponse")
	public SoapResponse getUsersByRole(@WebParam(name = "userName", targetNamespace = "") String userName,
			@WebParam(name = "password", targetNamespace = "") String password,
			@WebParam(name = "role", targetNamespace = "") String role);

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "deleteUser", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.DeleteUser")
	@ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.DeleteUserResponse")
	public SoapResponse deleteUser(@WebParam(name = "userName", targetNamespace = "") String userName,
			@WebParam(name = "password", targetNamespace = "") String password,
			@WebParam(name = "name", targetNamespace = "") String name);

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getAllUsers", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.GetAllUsers")
	@ResponseWrapper(localName = "getAllUsersResponse", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.GetAllUsersResponse")
	public SoapResponse getAllUsers(@WebParam(name = "userName", targetNamespace = "") String userName,
			@WebParam(name = "password", targetNamespace = "") String password);

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "authorize", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.Authorize")
	@ResponseWrapper(localName = "authorizeResponse", targetNamespace = "http://soap.service.lab.epam.com/", className = "com.epam.lab.client.responses.soapResponse.AuthorizeResponse")
	public SoapResponse authorize(@WebParam(name = "userName", targetNamespace = "") String userName,
			@WebParam(name = "password", targetNamespace = "") String password);

}
