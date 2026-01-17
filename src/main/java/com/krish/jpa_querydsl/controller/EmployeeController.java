package com.krish.jpa_querydsl.controller;


import com.krish.jpa_querydsl.dto.EmployeeFilterRequest;
import com.krish.jpa_querydsl.dto.EmployeeResponseDto;
import com.krish.jpa_querydsl.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @PostMapping("/search")
    public List<EmployeeResponseDto> searchEmployees(
            @RequestBody EmployeeFilterRequest filter) {
        return service.getEmployeesByFilters(filter);
    }
}
