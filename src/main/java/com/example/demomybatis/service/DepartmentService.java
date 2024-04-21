package com.example.demomybatis.service;

import com.example.demomybatis.model.Department;
import com.example.demomybatis.model.request.DepartmentRequest;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    Department getDepartmentById(Integer departmentId);

    Department addDepartment(DepartmentRequest departmentRequest);

    Department updateDepartment(Integer departmentId,DepartmentRequest departmentRequest);

    Department deleteDepartment(Integer departmentId);
}
