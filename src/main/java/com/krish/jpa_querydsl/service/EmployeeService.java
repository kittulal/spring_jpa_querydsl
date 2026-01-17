package com.krish.jpa_querydsl.service;

import com.krish.jpa_querydsl.dto.EmployeeCreateRequest;
import com.krish.jpa_querydsl.dto.EmployeeFilterRequest;
import com.krish.jpa_querydsl.dto.EmployeeResponseDto;
import com.krish.jpa_querydsl.entity.Department;
import com.krish.jpa_querydsl.entity.Employee;
import com.krish.jpa_querydsl.repository.DepartmentRepository;
import com.krish.jpa_querydsl.repository.EmployeeRepository;
import com.krish.jpa_querydsl.utils.EmployeeMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public EmployeeService(EmployeeRepository employeeRepo,
                           DepartmentRepository departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public List<EmployeeResponseDto> getEmployeesByFilters(EmployeeFilterRequest filter) {
        List<Employee> employeeList = employeeRepo.searchEmployees(filter);
        return employeeList.stream().map(EmployeeMapper::mapToDto).toList();
    }


}
