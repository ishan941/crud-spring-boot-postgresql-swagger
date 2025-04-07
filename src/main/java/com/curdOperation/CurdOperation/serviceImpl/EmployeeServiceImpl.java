package com.curdOperation.CurdOperation.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curdOperation.CurdOperation.dto.EmployeeDto;
import com.curdOperation.CurdOperation.model.Employee;
import com.curdOperation.CurdOperation.repository.EmployeeRepository;
import com.curdOperation.CurdOperation.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.builder().email(employeeDto.getEmail()).name(employeeDto.getName())
                .phone(employeeDto.getPhone()).build();
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.isEmpty() ? new ArrayList<>() : employees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee  not found for ID: " + id));

    }

    @Override
    public void updateEmployee(Long id, Employee emp) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            Employee editEmployee = employee.get();
            if (emp.getName() != null) {
                editEmployee.setName(emp.getName());
            }
            if (emp.getEmail() != null) {
                editEmployee.setEmail(emp.getEmail());
            }
            if (emp.getPhone() != null) {
                editEmployee.setPhone(emp.getPhone());
            }
            employeeRepository.save(editEmployee);
        } else {
            throw new RuntimeException("Teacher with id" + id + "not found.");
        }
    }

}
