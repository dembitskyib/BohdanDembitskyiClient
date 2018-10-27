
package com.epam.lab.client.responses.soapResponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.client.models.User;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapResponse", propOrder = { "message", "user" })
public class SoapResponse {
	@XmlTransient
	private static final Logger LOGGER = LogManager.getLogger(SoapResponse.class);
	@XmlTransient
	private final String RESPONSE_MESSAGE = "SOAP response message: %s";
	@XmlTransient
	private final String USERS_MESSAGE = "SOAP response users: %s";
	protected String message;
	@XmlElement(namespace = "http://soap.service.lab.epam.com/")
	protected List<User> user;

	public String getMessage() {
		LOGGER.info(String.format(RESPONSE_MESSAGE, message));
		return message;
	}

	public void setMessage(String value) {
		this.message = value;
	}

	public List<User> getUser() {
		if (user == null) {
			user = new ArrayList<User>();
		}
		LOGGER.info(String.format(USERS_MESSAGE, message));
		return this.user;
	}

}
