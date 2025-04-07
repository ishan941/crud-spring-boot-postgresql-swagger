package com.curdOperation.CurdOperation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.curdOperation.CurdOperation.apiResponse.ApiResponse;
import com.curdOperation.CurdOperation.dto.EmployeeDto;
import com.curdOperation.CurdOperation.model.Employee;
import com.curdOperation.CurdOperation.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> postMethodName(@RequestBody EmployeeDto employeeDto) {

        employeeService.saveEmployee(employeeDto);
        try {
            ApiResponse apiResponse = ApiResponse.builder().message("Successfully Created")
                    .statusCode(HttpStatus.OK.value()).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            ApiResponse apiResponse = ApiResponse.builder().message("Failed")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<ApiResponse> getMethodName() {
        List<Employee> employee = employeeService.getAllEmployees();
        try {
            ApiResponse apiResponse = ApiResponse.<Employee>builder().listData(employee).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            ApiResponse apiResponse = ApiResponse.builder().message("Failed")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

        }
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        try {
            ApiResponse apiResponse = ApiResponse.builder().date(employee).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            ApiResponse apiResponse = ApiResponse.builder().message("Failed")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @PatchMapping("/updateEmployee/{id}")
    public ResponseEntity<ApiResponse> patchMapping(@PathVariable Long id, Employee employee) {
        employeeService.updateEmployee(id, employee);
        try {
            ApiResponse apiResponse = ApiResponse.builder().message("Successfully Updated")
                    .statusCode(HttpStatus.OK.value()).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            ApiResponse apiResponse = ApiResponse.builder().message("Failed")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }

    }

}
