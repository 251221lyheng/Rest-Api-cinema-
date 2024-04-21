package com.example.demomybatis.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String employeeName;
    private LocalDateTime dateOfBirth;
    private Integer departmentId;
    private List<Integer> projectIds;


}
