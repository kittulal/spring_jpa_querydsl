package com.krish.jpa_querydsl.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Utility {
    public static Map<String, Employee> getEmpMap() {
        HashMap<String, Employee> map = new HashMap<>();
        Employee emp1 = new Employee("Krishna", 36, 50000, "ADCON");
        Employee emp2 = new Employee("Aditya", 24, 20000, "ADCON");
        Employee emp3 = new Employee("Yegy", 24, 18000, "ADCON");
        Employee emp4 = new Employee("Maria", 36, 15000, "ADCON");
        Employee emp5 = new Employee("Bille", 50, 40000, "ADCON");
        Employee emp6 = new Employee("Rajesh", 42, 80000, "CTRSTS");
        Employee emp7 = new Employee("Suresh", 38, 70000, "CTRSTS");
        Employee emp8 = new Employee("Kiran", 42, 70000, "CTRSTS");
        Employee emp9 = new Employee("Tharun", 25, 40000, "CTRSTS");
        Employee emp10 = new Employee("Vijender", 41, 70000, "CTRPC");
        Employee emp11 = new Employee("Vijender", 41, 70000, "CTRPC");
        Employee emp12 = new Employee("Srini", 45, 120000, "CTRPC");
        Employee emp13 = new Employee("Purna", 44, 100000, "CTRPC");
        Employee emp14 = new Employee("Manoj", 34, 30000, "CREEP");
        Employee emp15 = new Employee("Kalyani", 38, 40000, "CREEP");
        Employee emp16 = new Employee("Vamshi", 38, 50000, "CREEP");

        map.put(emp1.getName(), emp1);
        map.put(emp2.getName(), emp2);
        map.put(emp3.getName(), emp3);
        map.put(emp4.getName(), emp4);
        map.put(emp5.getName(), emp5);
        map.put(emp6.getName(), emp5);
        map.put(emp7.getName(), emp5);
        map.put(emp8.getName(), emp5);
        map.put(emp9.getName(), emp5);
        map.put(emp10.getName(), emp5);
        map.put(emp11.getName(), emp5);
        map.put(emp12.getName(), emp5);
        map.put(emp13.getName(), emp5);
        map.put(emp14.getName(), emp5);
        map.put(emp15.getName(), emp5);
        map.put(emp16.getName(), emp5);

        return map;

    }
    public static List<Employee> getEmplist(){
        Employee emp1 = new Employee("Krishna", 36, 50000, "ADCON");
        Employee emp2 = new Employee("Aditya", 24, 20000, "ADCON");
        Employee emp3 = new Employee("Yegy", 24, 18000, "ADCON");
        Employee emp4 = new Employee("Maria", 36, 15000, "ADCON");
        Employee emp5 = new Employee("Bille", 50, 40000, "ADCON");
        Employee emp6 = new Employee("Rajesh", 42, 80000, "CTRSTS");
        Employee emp7 = new Employee("Suresh", 38, 70000, "CTRSTS");
        Employee emp8 = new Employee("Kiran", 42, 70000, "CTRSTS");
        Employee emp9 = new Employee("Tharun", 25, 40000, "CTRSTS");
        Employee emp10 = new Employee("Vijender", 41, 70000, "CTRPC");
        Employee emp11 = new Employee("Vijender", 41, 70000, "CTRPC");
        Employee emp12 = new Employee("Srini", 45, 120000, "CTRPC");
        Employee emp13 = new Employee("Purna", 44, 100000, "CTRPC");
        Employee emp14 = new Employee("Manoj", 34, 30000, "CREEP");
        Employee emp15 = new Employee("Kalyani", 38, 40000, "CREEP");
        Employee emp16 = new Employee("Vamshi", 38, 50000, "CREEP");

        return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10,
                emp11, emp12, emp13, emp14, emp15, emp16);
    }
}
