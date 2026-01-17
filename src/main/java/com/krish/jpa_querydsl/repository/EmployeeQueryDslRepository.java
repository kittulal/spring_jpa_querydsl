package com.krish.jpa_querydsl.repository;

import com.krish.jpa_querydsl.dto.EmployeeFilterRequest;
import com.krish.jpa_querydsl.entity.Employee;

import java.util.List;

public interface EmployeeQueryDslRepository {
    List<Employee> searchEmployees(EmployeeFilterRequest filter);
}