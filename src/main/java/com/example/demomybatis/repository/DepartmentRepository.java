package com.example.demomybatis.repository;

import com.example.demomybatis.model.Department;
import com.example.demomybatis.model.request.DepartmentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentRepository {

    // Query to Get all Department
    @Select("""
        SELECT * FROM  departments;
""")
    @Results(id="departmentMapping",value = {
            @Result(property = "departmentId",column = "department_id"),
            @Result(property = "departmentName",column = "department_name")

    })
    List<Department> getAllDepartment();

    // Query to get Department by Id
    @Select("""
        SELECT * FROM  departments WHERE  department_id = #{departmentId}
""")
    @ResultMap("departmentMapping")
    Department getDepartmentById(Integer departmentId);

    @Select("""
        INSERT INTO departments VALUES (default,#{departmentMapper.departmentName},#{departmentMapper.location})
""")
    @ResultMap("departmentMapping")
    Department addDepartment(@Param("departmentMapper") DepartmentRequest departmentRequest);

    @Select("""
        UPDATE departments SET  department_name = #{departmentMapper.departmentName},location = #{departmentMapper.location} WHERE department_id = #{departmentId}
""")
    @ResultMap("departmentMapping")
    Department updateDepartment(Integer departmentId,@Param("departmentMapper") DepartmentRequest departmentRequest);

    @Select("""
        DELETE FROM departments WHERE department_id = #{departmentId}
""")
    @ResultMap("departmentMapping")
    Department deleteDepartment(Integer departmentId);
}
