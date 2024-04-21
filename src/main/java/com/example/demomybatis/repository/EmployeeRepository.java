package com.example.demomybatis.repository;


import com.example.demomybatis.model.Department;
import com.example.demomybatis.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeRepository {

    @Select("""
            SELECT * FROM employees;
""")
    @Results(id = "employeeMapping",value = {
            @Result(property = "employeeId",column = "employee_id"),
            @Result(property = "employeeName",column = "employee_name"),
            @Result(property = "dateOfBirth",column = "date_of_birth"),
            @Result(property = "department",column = "department_id",one = @One(select = "getDepartmentById"))
    })
    List<Employee> getAllEmployees();

    @Select("""
        SELECT  * FROM departments WHERE department_id = #{departmentId}
""")
    @Results(id = "departmentMapping",value = {
            @Result(property = "departmentId",column = "department_id"),
            @Result(property = "departmentName",column = "department_name")
    })
    Department getDepartmentById(Integer departmentId);
}
