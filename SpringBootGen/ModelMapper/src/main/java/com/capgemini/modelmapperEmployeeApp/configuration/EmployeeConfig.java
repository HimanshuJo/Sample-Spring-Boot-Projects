package com.capgemini.modelmapperEmployeeApp.configuration;

import com.capgemini.modelmapperEmployeeApp.service.EmployeeService;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

	@Bean
	public EmployeeService employeeBean() {
		return new EmployeeService();
	}

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}

}
