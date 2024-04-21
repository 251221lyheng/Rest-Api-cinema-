package com.example.demomybatis.controller;

import com.example.demomybatis.model.Employee;
import com.example.demomybatis.service.EmployeeService;
import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService ){
        this.employeeService = employeeService;
    }

    // Get all Employees
    @GetMapping
    public List<Employee> getAllEmployees (){
        return employeeService.getAllEmployees();
    }
}
