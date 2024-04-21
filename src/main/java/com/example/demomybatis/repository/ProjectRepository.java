package com.example.demomybatis.repository;

import com.example.demomybatis.model.Project;
import com.example.demomybatis.model.request.ProjectRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface ProjectRepository {

    // Query to get all projects
    @Select("""
        SELECT * FROM projects;
""")
    @Results(id = "projectMapping",value = {
            @Result(property = "projectId",column = "project_id"),
            @Result(property = "projectName",column = "project_name")
    })
    List<Project> getAllProjects();

    // Query to get Project by Id
    @Select("""
        SELECT * FROM  projects WHERE project_id = #{projectId};
""")
    @ResultMap("projectMapping")
    Project getProjectById(Integer projectId);

    @Select("""
        INSERT INTO projects VALUES (default,#{projectMapper.projectName},#{projectMapper.description})
""")
    @ResultMap("projectMapping")
    Project addProject(@Param("projectMapper") ProjectRequest projectRequest);

    @Select("""
        UPDATE projects SET  project_name = #{projectMapper.projectName},description = #{projectMapper.description} WHERE project_id = #{projectId} RETURNING *;
""")
    @ResultMap("projectMapping")
    Project updateProject(Integer projectId, @Param("projectMapper") ProjectRequest projectRequest);

    @Select("""
        DELETE FROM  projects WHERE project_id = #{projectId}
""")
    @ResultMap("projectMapping")
    Project deleteProject(Integer projectId);
}