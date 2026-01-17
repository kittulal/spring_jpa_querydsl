package com.krish.jpa_querydsl.dto;

public record EmployeeResponseDto(
        Long id,
        String empCode,
        String name,
        String email,
        String designation,
        Double salary,
        String status,
        String departmentCode
) {}
