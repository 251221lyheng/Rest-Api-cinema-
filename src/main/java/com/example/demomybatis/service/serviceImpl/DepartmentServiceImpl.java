package com.example.demomybatis.service.serviceImpl;

import com.example.demomybatis.model.Department;
import com.example.demomybatis.model.request.DepartmentRequest;
import com.example.demomybatis.repository.DepartmentRepository;
import com.example.demomybatis.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    public  DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {
        return departmentRepository.getDepartmentById(departmentId);
    }

    @Override
    public Department addDepartment(DepartmentRequest departmentRequest) {
        return departmentRepository.addDepartment(departmentRequest);
    }



    @Override
    public Department updateDepartment(Integer departmentId, DepartmentRequest departmentRequest) {
        return departmentRepository.updateDepartment(departmentId,departmentRequest);
    }

    @Override
    public Department deleteDepartment(Integer departmentId) {
        return departmentRepository.deleteDepartment(departmentId);
    }
}
