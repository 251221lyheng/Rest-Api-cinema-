package com.example.demomybatis.repository;


import com.example.demomybatis.model.Department;
import com.example.demomybatis.model.Employee;
import com.example.demomybatis.model.Project;
import com.example.demomybatis.model.request.EmployeeRequest;
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
            // relationship one to many query to get by id
            @Result(property = "department",column = "department_id",one = @One(select = "getDepartmentById")),
            // relationship many to many must  join with ceter table and query by id
            @Result(property = "projectList",column = "employee_id",many = @Many(select = "getProjectById"))
    })
    List<Employee> getAllEmployees();

    @Select("""
        SELECT  * FROM departments WHERE department_id = #{departmentId}
""")
    @Results(id = "departmentMapping",value = {
            @Result(property = "departmentId",column = "department_id"),
            @Result(property = "departmentName",column = "department_name")
    })
    // Get department by id
    Department getDepartmentById(Integer departmentId);

    @Select("""
        SELECT * FROM  projects inner join employee_project ep on projects.project_id = ep.project_id WHERE employee_id = #{employeeId}
""")
    @Results(id = "projectMapping",value = {
            @Result(property = "projectId",column = "project_id"),
            @Result(property = "projectName",column = "project_name"),
    })

    // Get Project by employee id
    List<Project> getProjectById(Integer employeeId);

    @Select("""
        SELECT  * FROM  employees WHERE employee_id = #{employeeId}
""")
    @ResultMap("employeeMapping")
    Employee getEmployeeById(Integer employeeId);

    @Select("""
        INSERT INTO employees VALUES (default,#{employeeMapper.employeeName},#{employeeMapper.dateOfBirth},#{employeeMapper.departmentId}) RETURNING *;
""")
    @ResultMap("employeeMapping")
    Employee addEmployee(@Param("employeeMapper") EmployeeRequest employeeRequest);

    @Insert("""
        INSERT INTO employee_project VALUES (default, #{projectId},#{employeeId});
""")
    void addEmployeeProject(Integer employeeId,Integer projectId);


    @Select("""
        UPDATE employees SET  employee_name = #{employeeMapper.employeeName},date_of_birth = #{employeeMapper.dateOfBirth},department_id = #{employeeMapper.departmentId} WHERE employee_id = #{employeeId}
""")
    Employee updateEmplyee(Integer employeeId,@Param("employeeMapper") EmployeeRequest employeeRequest);
}
