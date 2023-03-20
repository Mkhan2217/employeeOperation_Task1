package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeValidation employeeValidation;

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeNotFoundException {
		if (employeeValidation.isValidate(employee)) return employeeRepository.save(employee);
		throw new EmployeeNotFoundException("user is not found");
		

	}

	@Override
	public List<Employee> addListOfEmployee(List<Employee> emList) {
		for (Employee employee : emList) {
			
		}
		return employeeRepository.saveAll(emList);
	}

	@Override
	public Employee updateById(Employee employee, String empId) {
		Employee emp1 = employeeRepository.findById(empId).get();
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			emp1.setFirstName(employee.getFirstName());
		}
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			emp1.setLastName(employee.getLastName());
		}
		if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
			emp1.setEmail(employee.getEmail());
		}
		if (Objects.nonNull(employee.getPhone()) && !"".equalsIgnoreCase(employee.getPhone())) {
			emp1.setPhone(employee.getPhone());
		}
		if (Objects.nonNull(employee.getDateOfBirth())) {
			emp1.setDateOfBirth(employee.getDateOfBirth());
		}
		if (Objects.nonNull(employee.getGender()) && !"".equals(employee.getGender())) {
			emp1.setGender(employee.getGender());
		}
		if (Objects.nonNull(employee.getProfilePhoto()) && !"".equalsIgnoreCase(employee.getProfilePhoto())) {
			emp1.setProfilePhoto(employee.getProfilePhoto());
		}

		emp1.setEmpUpdateDate(LocalDate.now());
		return employeeRepository.save(emp1);
	}

	@Override
	public Employee fetchByIdByEmailByPhone(String empId, String email, String phone) {
		return employeeRepository.findByUserIdOrEmailOrPhone(empId, email, phone);

	}

	@Override
	public List<Employee> fetchListOfEmployee(Employee employee) {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> fetchByCreateDateBetween(LocalDate startDate, LocalDate endDate) {
		return employeeRepository.findByCreateDateBetween(startDate, endDate);
	}

	@Override
	public void deleteById(String empId) {
		employeeRepository.deleteById(empId);
	}

}
