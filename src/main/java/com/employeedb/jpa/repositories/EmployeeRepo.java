package com.employeedb.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeedb.jpa.entities.Contact;
import com.employeedb.jpa.entities.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Additional custom queries can be added here if needed
//	@Query(value = "SELECT * FROM employee", nativeQuery = true)
//    List<Employee> findAllemp();
//	
//	@Query(value = "SELECT * FROM employee  WHERE id = :id", nativeQuery = true)
//    Employee findByIdemp(Long id);
//
//	@Query(value = "insert into employee values(:id,:name)", nativeQuery = true)
//	Employee saveemp(Long id,String name);
}