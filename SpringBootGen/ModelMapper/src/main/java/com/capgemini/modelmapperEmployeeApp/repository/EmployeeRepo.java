package com.capgemini.modelmapperEmployeeApp.repository;

import com.capgemini.modelmapperEmployeeApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
