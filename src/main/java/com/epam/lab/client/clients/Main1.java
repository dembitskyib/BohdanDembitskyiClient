package com.epam.lab.client.clients;

import java.util.List;

import com.epam.lab.client.models.User;
import com.epam.lab.client.soapService.SoapUserService;
import com.epam.lab.client.soapService.SoapUserServiceImplService;

public class Main1 {
	public static void main(String[] args) {
		SoapUserServiceImplService soapServiceService = new SoapUserServiceImplService();
		SoapUserService soapService = soapServiceService.getSoapUserServiceImplPort();
		List<User> roles = soapService.getAllUsers("user1", "123456").getUser();
		roles.forEach(user -> {
			System.out.println(user.getUserName() + " " + user.getPassword() + " " + user.getRoleList());
		});
	}
}
