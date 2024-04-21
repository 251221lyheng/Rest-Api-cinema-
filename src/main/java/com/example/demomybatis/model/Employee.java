package com.example.demomybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private Integer employeeId;
    private  String employeeName;
    private LocalDateTime dateOfBirth;
    private Department department;
}
