package com.capgemini.mockmvc2.util;

public class GeekEmployeeIdGenerator {

	private static long employeeId = 1000;

	public static synchronized long value() {
		return employeeId++;
	}
}
