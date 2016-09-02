package com.example.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private int empId;
	private String empName;
	private String empJob;
	private int empManagerId;
	private Date empHireDate;
	private int empSalary;
}
