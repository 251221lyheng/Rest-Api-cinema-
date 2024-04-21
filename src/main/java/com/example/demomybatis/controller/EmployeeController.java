package com.example.demomybatis.controller;

import com.example.demomybatis.model.Employee;
import com.example.demomybatis.model.request.EmployeeRequest;
import com.example.demomybatis.service.EmployeeService;
import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public  Employee addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }
    @PutMapping("/{id}")
    public  Employee updateEmployee(@PathVariable("id") Integer employeeId,@RequestBody EmployeeRequest employeeRequest){
        return  employeeService.updateEmployee(employeeId,employeeRequest);
    }
}
