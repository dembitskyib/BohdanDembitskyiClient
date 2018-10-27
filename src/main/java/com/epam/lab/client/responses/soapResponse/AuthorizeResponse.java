
package com.epam.lab.client.responses.soapResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authorizeResponseClass", propOrder = { "_return" })
public class AuthorizeResponse {

	@XmlElement(name = "return")
	protected SoapResponse _return;

	public SoapResponse getReturn() {
		return _return;
	}

	public void setReturn(SoapResponse value) {
		this._return = value;
	}

}
