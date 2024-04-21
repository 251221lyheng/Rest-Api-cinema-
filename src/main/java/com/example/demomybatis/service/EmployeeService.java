package com.example.demomybatis.service;

import com.example.demomybatis.model.Employee;
import com.example.demomybatis.model.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    Employee addEmployee(EmployeeRequest employeeRequest);

    Employee updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
}
