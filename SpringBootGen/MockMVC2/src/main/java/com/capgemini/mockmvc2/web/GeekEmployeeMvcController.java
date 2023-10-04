package com.capgemini.mockmvc2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.mockmvc2.service.GeekEmployeeService;

@Controller
@RequestMapping("mvc")
public class GeekEmployeeMvcController {
	
	private final GeekEmployeeService geekEmployeeService;
	
	public GeekEmployeeMvcController(GeekEmployeeService geekEmployeeService) {
		this.geekEmployeeService = geekEmployeeService;
	}
	
	@GetMapping("geekemployees")
	public String getGeekEmployees(Model model) {
		model.addAttribute("geekemployees", geekEmployeeService.findAll());
		return "geekemployee-list";
	}

}
