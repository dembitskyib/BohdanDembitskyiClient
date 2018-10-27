
package com.epam.lab.service.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "role")
@XmlEnum
public enum Role {

	GUEST, USER, ADMIN;

	public String value() {
		return name();
	}

	public static Role fromValue(String v) {
		return valueOf(v);
	}

}
