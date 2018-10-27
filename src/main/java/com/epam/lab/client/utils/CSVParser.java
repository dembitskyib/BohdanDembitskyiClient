package com.epam.lab.client.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.client.models.Role;
import com.epam.lab.client.models.User;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVParser {
	public static User getUser(String filePath) {
		List<User> users = getUsers(filePath);
		return users.get(0);
	}

	public static List<User> getUsersByRole(String filePath, String role) {
		List<User> users = getUsers(filePath);
		List<User> usersByRole = new ArrayList<>();
		for (User user : users) {
			if (user.getRoleList().contains(Role.valueOf(role))) {
				usersByRole.add(user);
			}
		}
		return usersByRole;
	}

	public static List<User> getUsers(String filePath) {
		List<User> userList = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
				CSVReader csvReader = new CSVReader(reader);) {
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				User tempUser = new User();
				tempUser.setUserName(nextRecord[0].trim());
				tempUser.setPassword(nextRecord[1].trim());
				for (int i = 2; i < nextRecord.length; i++) {
					tempUser.addRole(nextRecord[i].trim());
				}
				userList.add(tempUser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public static boolean removeUser(String filePath, String name) {
		boolean isUserDeleted = false;
		List<User> userList = getUsers(filePath);
		Iterator<User> userIter = userList.iterator();
		while (userIter.hasNext()) {
			User user = userIter.next();
			if (user.getUserName().equals(name)) {
				isUserDeleted = true;
				userIter.remove();
			}
		}
		writeUsers(userList, filePath);
		return isUserDeleted;
	}

	private static void writeUsers(List<User> userList, String filePath) {
		try (Writer writer = Files.newBufferedWriter(Paths.get(filePath));
				CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);) {
			List<String[]> userArrays = new ArrayList<>();
			for (User user : userList) {
				List<Role> userRoles = user.getRoleList();
				List<String> nextLine = new ArrayList<>();
				nextLine.add(user.getUserName());
				nextLine.add(user.getPassword());
				for (Role role : userRoles) {
					nextLine.add(role.toString());
				}
				userArrays.add(nextLine.toArray(new String[0]));
			}
			csvWriter.writeAll(userArrays);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
