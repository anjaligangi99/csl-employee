package com.scb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scb.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByEname(String ename);
	public List<Employee> findByEnameContains(String ename);
	
	@Query("select e from Employee e where ename=:ename and addr=:addr")
	public List<Employee> getEmployeeData(@Param("ename") String ename, @Param("addr") String addr);
	
	@Query(value = "select * from emp e where e.ename=:ename and e.addr=:addr", nativeQuery = true)
	public List<Employee> getEmployeeDetails(@Param("ename") String ename, @Param("addr") String addr);
	
	

}
