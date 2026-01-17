package com.krish.jpa_querydsl.repository;

import com.krish.jpa_querydsl.dto.EmployeeFilterRequest;
import com.krish.jpa_querydsl.entity.Employee;
import com.krish.jpa_querydsl.entity.QDepartment;
import com.krish.jpa_querydsl.entity.QEmployee;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeQueryDslRepositoryImpl
        implements EmployeeQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Employee> searchEmployees(EmployeeFilterRequest filter) {

        QEmployee employee = QEmployee.employee;
        QDepartment department = QDepartment.department;

        BooleanBuilder builder = new BooleanBuilder();

        // firstName
        if (hasText(filter.getFirstName())) {
            builder.and(employee.firstName
                    .equalsIgnoreCase(filter.getFirstName()));
        }

        // lastName
        if (hasText(filter.getLastName())) {
            builder.and(employee.lastName
                    .containsIgnoreCase(filter.getLastName()));
        }

        // email
        if (hasText(filter.getEmail())) {
            builder.and(employee.email
                    .equalsIgnoreCase(filter.getEmail()));
        }

        // status
        if (hasText(filter.getStatus())) {
            builder.and(employee.status.eq(filter.getStatus()));
        }

        // department name
        if (hasText(filter.getDepartmentName())) {
            builder.and(employee.department.name
                    .containsIgnoreCase(filter.getDepartmentName()));
        }

        return queryFactory
                .selectFrom(employee)
                .leftJoin(employee.department, department).fetchJoin()
                .where(builder)
                .distinct()
                .orderBy(employee.firstName.asc())
                .fetch();
    }

    private boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
