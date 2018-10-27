
package com.epam.lab.client.soapService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.epam.lab.client.models.Role;
import com.epam.lab.client.models.User;
import com.epam.lab.client.responses.soapResponse.Authenticate;
import com.epam.lab.client.responses.soapResponse.AuthenticateResponse;
import com.epam.lab.client.responses.soapResponse.Authorize;
import com.epam.lab.client.responses.soapResponse.AuthorizeResponse;
import com.epam.lab.client.responses.soapResponse.DeleteUser;
import com.epam.lab.client.responses.soapResponse.DeleteUserResponse;
import com.epam.lab.client.responses.soapResponse.GetAllUsers;
import com.epam.lab.client.responses.soapResponse.GetAllUsersResponse;
import com.epam.lab.client.responses.soapResponse.GetUsersByRole;
import com.epam.lab.client.responses.soapResponse.GetUsersByRoleResponse;
import com.epam.lab.client.responses.soapResponse.SoapResponse;

@XmlRegistry
public class ObjectFactory {

	private final static QName _GetUsersByRoleResponse_QNAME = new QName("http://soap.service.lab.epam.com/",
			"getUsersByRoleResponse");
	private final static QName _DeleteUser_QNAME = new QName("http://soap.service.lab.epam.com/", "deleteUser");
	private final static QName _DeleteUserResponse_QNAME = new QName("http://soap.service.lab.epam.com/",
			"deleteUserResponse");
	private final static QName _Authorize_QNAME = new QName("http://soap.service.lab.epam.com/", "authorize");
	private final static QName _AuthorizeResponse_QNAME = new QName("http://soap.service.lab.epam.com/",
			"authorizeResponse");
	private final static QName _User_QNAME = new QName("http://soap.service.lab.epam.com/", "user");
	private final static QName _GetAllUsersResponse_QNAME = new QName("http://soap.service.lab.epam.com/",
			"getAllUsersResponse");
	private final static QName _Authenticate_QNAME = new QName("http://soap.service.lab.epam.com/", "authenticate");
	private final static QName _GetUsersByRole_QNAME = new QName("http://soap.service.lab.epam.com/", "getUsersByRole");
	private final static QName _Role_QNAME = new QName("http://soap.service.lab.epam.com/", "role");
	private final static QName _GetAllUsers_QNAME = new QName("http://soap.service.lab.epam.com/", "getAllUsers");
	private final static QName _AuthenticateResponse_QNAME = new QName("http://soap.service.lab.epam.com/",
			"authenticateResponse");

	public ObjectFactory() {
	}

	public GetAllUsers createGetAllUsers() {
		return new GetAllUsers();
	}

	public GetAllUsersResponse createGetAllUsersResponse() {
		return new GetAllUsersResponse();
	}

	public Authenticate createAuthenticate() {
		return new Authenticate();
	}

	public GetUsersByRole createGetUsersByRole() {
		return new GetUsersByRole();
	}

	public AuthenticateResponse createAuthenticateResponse() {
		return new AuthenticateResponse();
	}

	public DeleteUser createDeleteUser() {
		return new DeleteUser();
	}

	public GetUsersByRoleResponse createGetUsersByRoleResponse() {
		return new GetUsersByRoleResponse();
	}

	public Authorize createAuthorize() {
		return new Authorize();
	}

	public AuthorizeResponse createAuthorizeResponse() {
		return new AuthorizeResponse();
	}

	public User createUser() {
		return new User();
	}

	public DeleteUserResponse createDeleteUserResponse() {
		return new DeleteUserResponse();
	}

	public SoapResponse createSoapResponse() {
		return new SoapResponse();
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "getUsersByRoleResponse")
	public JAXBElement<GetUsersByRoleResponse> createGetUsersByRoleResponse(GetUsersByRoleResponse value) {
		return new JAXBElement<GetUsersByRoleResponse>(_GetUsersByRoleResponse_QNAME, GetUsersByRoleResponse.class,
				null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "deleteUser")
	public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
		return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "deleteUserResponse")
	public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
		return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "authorize")
	public JAXBElement<Authorize> createAuthorize(Authorize value) {
		return new JAXBElement<Authorize>(_Authorize_QNAME, Authorize.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "authorizeResponse")
	public JAXBElement<AuthorizeResponse> createAuthorizeResponse(AuthorizeResponse value) {
		return new JAXBElement<AuthorizeResponse>(_AuthorizeResponse_QNAME, AuthorizeResponse.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "user")
	public JAXBElement<User> createUser(User value) {
		return new JAXBElement<User>(_User_QNAME, User.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "getAllUsersResponse")
	public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
		return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "authenticate")
	public JAXBElement<Authenticate> createAuthenticate(Authenticate value) {
		return new JAXBElement<Authenticate>(_Authenticate_QNAME, Authenticate.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "getUsersByRole")
	public JAXBElement<GetUsersByRole> createGetUsersByRole(GetUsersByRole value) {
		return new JAXBElement<GetUsersByRole>(_GetUsersByRole_QNAME, GetUsersByRole.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "role")
	public JAXBElement<Role> createRole(Role value) {
		return new JAXBElement<Role>(_Role_QNAME, Role.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "getAllUsers")
	public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
		return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
	}

	@XmlElementDecl(namespace = "http://soap.service.lab.epam.com/", name = "authenticateResponse")
	public JAXBElement<AuthenticateResponse> createAuthenticateResponse(AuthenticateResponse value) {
		return new JAXBElement<AuthenticateResponse>(_AuthenticateResponse_QNAME, AuthenticateResponse.class, null,
				value);
	}

}
