
package com.epam.lab.client.responses.soapResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUsersByRoleClass", propOrder = { "userName", "password", "role" })
public class GetUsersByRole {

	protected String userName;
	protected String password;
	protected String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String value) {
		this.userName = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String value) {
		this.role = value;
	}

}
