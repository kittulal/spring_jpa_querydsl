package com.krish.jpa_querydsl.collections;

import jdk.jshell.execution.Util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        Map<String, Employee> map = Utility.getEmpMap();

        Utility.getEmplist().stream().collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        )).forEach((k,v)->{
            System.out.println(k+":"+": "+v.get().getName()+" - "+v.get().getSalary());
        });

        Utility.getEmplist().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((k,v)->{
            System.out.println(k+" : "+v);
        });
        Utility.getEmplist().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary))).forEach((k,v)->{
            System.out.println(k+" : "+v);
        });
        Map<String, Map<String, List<Employee>>> nestedgroups =
                Utility.getEmplist().stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(emp->{
                            if(emp.getSalary()<30000){
                                return "BADGE-1";
                            } else if(emp.getSalary()>30000 && emp.getSalary()<50000){
                                return "BADGE-2";
                            }else if(emp.getSalary()>50000 && emp.getSalary()<80000){
                                return "BADGE-3";
                            }else{
                                return "BADGE-4";
                            }
                        })
                ));


        nestedgroups.forEach((k,v)->{
            System.out.println("--------------------------");
            System.out.println("Department : "+k);
            System.out.println("--------------------------");
            System.out.println("---------Its Sal ranges ---- ");
            v.entrySet().stream().forEach(e->{
                List<Employee> e1 = (List<Employee>) e.getValue();
                e1.forEach( employee -> System.out.println(e.getKey()+" : "+employee.getName()+" - "+employee.getSalary()));
            });
        });
    }

}
