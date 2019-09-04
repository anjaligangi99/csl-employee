package com.scb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.scb.entity.Employee;
import com.scb.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public String saveEmployee(Employee employee) {
		String result = null;

		if (employeeRepository.save(employee) != null) {
			result = "Employee Details Saved Successfully";
		} else {
			result = "Something Went wrong..";
		}
		return result;
	}

	public List<Employee> getAllEmpDetails() {
		
	//	List<Employee> employees = employeeRepository.findAll();
		/*
		 * List<Employee> employees = employeeRepository.findAll(new
		 * Sort(Sort.Direction.DESC, "ename"). and(new Sort(Sort.Direction.DESC,
		 * "addr")));
		 */
		/*
		 * Pageable pageable = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC,
		 * "ename")); List<Employee> employees =
		 * employeeRepository.findAll(pageable).getContent();
		 */
		
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	public Optional<Employee> getEmployeeDetailsById(Integer id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}

	public String updateEmployee(Employee employee) {
		String result = null;

		if (employeeRepository.save(employee) != null) {
			result = "Employee Details updated Successfully";
		} else {
			result = "Something Went wrong..";
		}
		return result;

	}

	public void deleteEmployeeById(Integer id) {

		employeeRepository.deleteById(id);
	}
	
	/** Derived Queries Methods */
	
	public List<Employee> findByEname(String ename){
		return employeeRepository.findByEname(ename);
	}
	
	public List<Employee> findByEnameContains(String ename){
		return employeeRepository.findByEnameContains(ename);
	}

	public List<Employee> getEmployeeData(String ename, String addr){
		return employeeRepository.getEmployeeData(ename, addr); 
	}
	
	public List<Employee> getEmployeeDetails( String ename,  String addr){
		return employeeRepository.getEmployeeDetails(ename, addr);
	}
}
