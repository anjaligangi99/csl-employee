package com.scb.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.Employee;
import com.scb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private Logger logger = LogManager.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST )
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		logger.info("Controller Started ....");
		return new ResponseEntity<String>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	@GetMapping("/empDtlsAll") public List<Employee> getAllEmpDetails(){
			List<Employee> employees = employeeService.getAllEmpDetails(); 
			return employees; 
	}
	  @GetMapping("/{id}") public Optional<Employee>
	  getEmployeeDetailsById(@PathVariable Integer id) { 
		  logger.info("Controller Started & Entering into getEmployeeDetailsById...."); 
		  logger.info("Controller Started ...."); 
		  Optional<Employee> emOptional = employeeService.getEmployeeDetailsById(id); return emOptional; }
	  
	  @PutMapping("/update/{id}") public ResponseEntity<String>
	  updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
	  Employee employeeFromDB = employeeService.getEmployeeDetailsById(id).get();
	  employeeFromDB.setEname(employee.getEname());
	  employeeFromDB.setAddr(employee.getAddr()); return new
	  ResponseEntity<String>(employeeService.updateEmployee(employeeFromDB),
	  HttpStatus.CREATED);
	  
	  }
	  
	  @PutMapping("/delete/{id}") public ResponseEntity<String>
	  deleteEmployeeById(@PathVariable Integer id) {
	  employeeService.deleteEmployeeById(id); return new
	  ResponseEntity("Product deleted successfully", HttpStatus.OK); }
	  
	  /** Derived Method queries  */
	 
	  @GetMapping("/findByName")
	  public ResponseEntity<List<Employee>> findByEname(@RequestParam String ename){
		    return new ResponseEntity<List<Employee>>(employeeService.findByEname(ename),HttpStatus.OK);
		  
	  }
	  
	  @GetMapping("/findByEnameContains")
	  public ResponseEntity<List<Employee>> findByEnameContains(@RequestParam String ename){
		 return new ResponseEntity<List<Employee>>(employeeService.findByEnameContains(ename), HttpStatus.OK);
	  }
	  
	  @GetMapping("/getEmployeeData")
	  public ResponseEntity<List<Employee>> getEmployeeData(@RequestParam String ename, String addr){
		  return new ResponseEntity<List<Employee>>(employeeService.getEmployeeData(ename,addr), HttpStatus.OK);
	  }
	  @GetMapping("/getEmployeeDetails")
	  public ResponseEntity<List<Employee>> getEmployeeDetails(@RequestParam String ename,  String addr){
		  return new ResponseEntity<List<Employee>>(employeeService.getEmployeeDetails(ename, addr), HttpStatus.OK);
	  }
}
