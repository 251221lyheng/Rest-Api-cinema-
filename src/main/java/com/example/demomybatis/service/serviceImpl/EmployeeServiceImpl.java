package com.example.demomybatis.service.serviceImpl;

import com.example.demomybatis.model.Employee;
import com.example.demomybatis.model.request.EmployeeRequest;
import com.example.demomybatis.repository.EmployeeRepository;
import com.example.demomybatis.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @Override
    public Employee addEmployee(EmployeeRequest employeeRequest) {
        Employee employee =  employeeRepository.addEmployee(employeeRequest);
        for(Integer projectId : employeeRequest.getProjectIds()){
            employeeRepository.addEmployeeProject(employee.getEmployeeId(), projectId);
        }
        return getEmployeeById(employee.getEmployeeId());
    }

    @Override
    public Employee updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) {
        return  employeeRepository.updateEmplyee(employeeId,employeeRequest);
    }


}
