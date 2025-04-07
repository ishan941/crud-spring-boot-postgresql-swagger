package com.curdOperation.CurdOperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curdOperation.CurdOperation.dto.EmployeeDto;
import com.curdOperation.CurdOperation.model.Employee;

@Service
public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);

    List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public void updateEmployee(Long id, Employee Employee);

}
