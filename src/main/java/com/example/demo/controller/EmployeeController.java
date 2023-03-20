package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return employeeService.addEmployee(employee);
	}

	@PostMapping("/addlist")
	public List<Employee> addListOfEmployee(@RequestBody List<Employee> emList) {
		return employeeService.addListOfEmployee(emList);

	}

	@PutMapping("/employee/{id}")
	public Employee updateById(@RequestBody Employee employee, @PathVariable("id") String empId) {
		return employeeService.updateById(employee, empId);

	}

	@GetMapping("/employeebyphone")
	public Employee fetchByIdByEmailByPhone(@PathVariable("id") String empId, @PathVariable("email") String email,
			@PathVariable("phone") String phone) {
		return employeeService.fetchByIdByEmailByPhone(empId, email, phone);
	}

	@GetMapping("/employee")
	public List<Employee> fetchListOfEmployee(@RequestBody Employee employee) {
		return employeeService.fetchListOfEmployee(employee);
	}

	@GetMapping("/fetchbydate")
	public List<Employee> fetchByCreateDateBetween(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		return employeeService.fetchByCreateDateBetween(startDate, endDate);

	}

	@DeleteMapping("/employee/{id}")
	public String deleteById(@PathVariable("id") String empId) {
		employeeService.deleteById(empId);
		return "Employee Deleted Successfully";

	}

}
