package com.capgemini.mockmvc2.web;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.mockmvc2.domain.GeekEmployee;
import com.capgemini.mockmvc2.service.GeekEmployeeService;
import com.capgemini.mockmvc2.util.GeekEmployeeIdGenerator;

@RestController
@RequestMapping("geekemployees")
public class GeekEmployeeRestController {

	private final GeekEmployeeService geekEmployeeService;
	
	public GeekEmployeeRestController(GeekEmployeeService service) {
		this.geekEmployeeService = service;
	}
	
	@GetMapping
	Collection<GeekEmployee> readGeekEmployees(){
		return this.geekEmployeeService.findAll();
	}
	
	@GetMapping("/{id}")
	GeekEmployee readGeekEmployee(@PathVariable Long id) {
		return this.geekEmployeeService.findById(id)
				.orElseThrow(GeekEmployeeNotFoundException::new);
	}
	
	@PostMapping
	ResponseEntity<?> addEmployee(@RequestBody GeekEmployee geekEmployee){
		// Hack to get Mockito test to work
		// Will fix this soon
		// When not running JUnit tests
		// These statements should be commented out
		// and the statements below should be uncommented
		this.geekEmployeeService.save(geekEmployee);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(GeekEmployeeIdGenerator.value())
				.toUri();
		
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	GeekEmployee updateEmployee(@RequestBody GeekEmployee geekEmployee) {
		return this.geekEmployeeService.update(geekEmployee)
				.orElseThrow(GeekEmployeeNotFoundException::new);
	}
	
	@DeleteMapping("/{id}")
	void deleteStudent(@PathVariable Long id) {
		this.geekEmployeeService.delete(id)
			.orElseThrow(GeekEmployeeNotFoundException::new);
	}		
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	class GeekEmployeeNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public GeekEmployeeNotFoundException() {
			super("Employee does not exist");
		}
	}
}
