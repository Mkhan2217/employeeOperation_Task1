package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;

public interface EmployeeService {

	Employee addEmployee(Employee employee) throws EmployeeNotFoundException;

	List<Employee> addListOfEmployee(List<Employee> emList);

	Employee updateById(Employee employee, String empId);

	Employee fetchByIdByEmailByPhone(String empId, String email, String phone);

	List<Employee> fetchListOfEmployee(Employee employee);

	void deleteById(String empId);

	List<Employee> fetchByCreateDateBetween(LocalDate startDate, LocalDate endDate);

}
