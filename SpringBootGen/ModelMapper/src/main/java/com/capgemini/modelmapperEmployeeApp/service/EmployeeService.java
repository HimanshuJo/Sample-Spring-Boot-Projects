package com.capgemini.modelmapperEmployeeApp.service;

import com.capgemini.modelmapperEmployeeApp.entity.Employee;
import com.capgemini.modelmapperEmployeeApp.repository.EmployeeRepo;
import com.capgemini.modelmapperEmployeeApp.response.EmployeeResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	public EmployeeResponse getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		return employeeResponse;
	}

}
