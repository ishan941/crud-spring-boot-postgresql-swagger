package com.curdOperation.CurdOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curdOperation.CurdOperation.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}