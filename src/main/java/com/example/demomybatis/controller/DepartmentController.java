package com.example.demomybatis.controller;

import com.example.demomybatis.model.Department;
import com.example.demomybatis.model.request.DepartmentRequest;
import com.example.demomybatis.service.DepartmentService;
import com.example.demomybatis.service.serviceImpl.DepartmentServiceImpl;
import org.springframework.aot.generate.InMemoryGeneratedFiles;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    // Get all Department
    @GetMapping
    public List<Department> getAllDepartment(){
        return  departmentService.getAllDepartment();
    }

    // Get Department by Id
    @GetMapping("/{id}")
    public Department getDepartmentById(Integer departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    // Create Department
    @PostMapping
    public Department addDepartment(@RequestBody DepartmentRequest departmentRequest){
        return  departmentService.addDepartment(departmentRequest);
    }

    // Update Department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Integer departmentId,@RequestBody DepartmentRequest departmentRequest){
        return departmentService.updateDepartment(departmentId,departmentRequest);
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public Department deleteDepartment(@PathVariable("id") Integer departmentId){
        return  departmentService.deleteDepartment(departmentId);
    }
}
