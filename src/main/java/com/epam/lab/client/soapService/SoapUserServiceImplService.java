
package com.epam.lab.client.soapService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SoapUserServiceImplService", targetNamespace = "http://soap.service.lab.epam.com/", wsdlLocation = "http://localhost:8888/BohdanDembitskyiService/soapUserService?WSDL")
public class SoapUserServiceImplService extends Service {

	private final static URL SOAPUSERSERVICEIMPLSERVICE_WSDL_LOCATION;
	private final static WebServiceException SOAPUSERSERVICEIMPLSERVICE_EXCEPTION;
	private final static QName SOAPUSERSERVICEIMPLSERVICE_QNAME = new QName("http://soap.service.lab.epam.com/",
			"SoapUserServiceImplService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL("http://localhost:8888/BohdanDembitskyiService/soapUserService?WSDL");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		SOAPUSERSERVICEIMPLSERVICE_WSDL_LOCATION = url;
		SOAPUSERSERVICEIMPLSERVICE_EXCEPTION = e;
	}

	public SoapUserServiceImplService() {
		super(__getWsdlLocation(), SOAPUSERSERVICEIMPLSERVICE_QNAME);
	}

	public SoapUserServiceImplService(WebServiceFeature... features) {
		super(__getWsdlLocation(), SOAPUSERSERVICEIMPLSERVICE_QNAME, features);
	}

	public SoapUserServiceImplService(URL wsdlLocation) {
		super(wsdlLocation, SOAPUSERSERVICEIMPLSERVICE_QNAME);
	}

	public SoapUserServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
		super(wsdlLocation, SOAPUSERSERVICEIMPLSERVICE_QNAME, features);
	}

	public SoapUserServiceImplService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public SoapUserServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	@WebEndpoint(name = "SoapUserServiceImplPort")
	public SoapUserService getSoapUserServiceImplPort() {
		return super.getPort(new QName("http://soap.service.lab.epam.com/", "SoapUserServiceImplPort"),
				SoapUserService.class);
	}

	@WebEndpoint(name = "SoapUserServiceImplPort")
	public SoapUserService getSoapUserServiceImplPort(WebServiceFeature... features) {
		return super.getPort(new QName("http://soap.service.lab.epam.com/", "SoapUserServiceImplPort"),
				SoapUserService.class, features);
	}

	private static URL __getWsdlLocation() {
		if (SOAPUSERSERVICEIMPLSERVICE_EXCEPTION != null) {
			throw SOAPUSERSERVICEIMPLSERVICE_EXCEPTION;
		}
		return SOAPUSERSERVICEIMPLSERVICE_WSDL_LOCATION;
	}

}
