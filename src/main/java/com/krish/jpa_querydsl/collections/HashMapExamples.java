package com.krish.jpa_querydsl.collections;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapExamples {

    public static void main(String[] args) {

        Map<String, Employee> map = createHashMap();
        Map<String, Employee> map1 = sortMapByKey(map);
        System.out.println("-Sorted By Tree Map---------------");
        map1.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        });

        Map<String, Employee> map2 = sortByValuesUsingStreams(map);
        System.out.println("-Sorting by Value---------------");
        map2.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        });
        Comparator<Map.Entry<String,Employee>> comparator = getSortingByMapKey();
        Map<String, Employee> map3 = sortMapByComparator(map,comparator);
        System.out.println("-sortMapByStreams By Key---------------");
        map3.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        });
        comparator = sortByNameAndAgeAndSalary();
        Map<String, Employee> map4 = sortMapByComparator(map,comparator);
        System.out.println("-sortMapBy By Value name, age and salary---------------");
        map4.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        });
    }
    public static Map<String, Employee> createHashMap() {
        HashMap<String, Employee> map = new HashMap<>();
        Employee emp1 = new Employee("Krishna", 36, 50000, "ADCON");
        Employee emp2 = new Employee("Rajesh", 42, 80000, "CTRSTS");
        Employee emp3 = new Employee("Vijender", 41, 70000, "CTRPC");
        Employee emp4 = new Employee("Srini", 45, 120000, "CTRBATCH");
        Employee emp5 = new Employee("Purna", 44, 100000, "CTRXR");

        map.put(emp1.getName(), emp1);
        map.put(emp2.getName(), emp2);
        map.put(emp3.getName(), emp3);
        map.put(emp4.getName(), emp4);
        map.put(emp5.getName(), emp5);

        return map;

    }

    public static Map<String, Employee> sortMapByKey(Map<String, Employee> map) {
        return new TreeMap<>(map);
    }



    public static Map<String, Employee> sortByValuesUsingStreams(Map<String, Employee> map) {
        Map<String, Employee> sortedMap = map.entrySet()
                // Step 1: Convert HashMap into a Set of Map.Entry (key-value pairs)

                .stream()
                // Step 2: Convert the Set into a Stream to enable functional operations

                .sorted(Map.Entry.comparingByKey())
                // Step 3: Sort the stream based on keys (String) in natural order (ascending)

                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        // Step 4.1: Extract key from each Map.Entry

                        Map.Entry::getValue,
                        // Step 4.2: Extract value (Employee) from each Map.Entry

                        (oldValue, newValue) -> oldValue,
                        // Step 4.3: Merge function (handles duplicate keys if any)
                        // If duplicate key occurs, keep the existing value and ignore the new one

                        LinkedHashMap::new
                        // Step 4.4: Specify the Map implementation to store results
                        // LinkedHashMap preserves insertion order
                        // Since entries are inserted after sorting, final map remains sorted
                ));
        return  map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue)-> oldValue,
                        LinkedHashMap::new));
    }

    public static Comparator<Map.Entry<String, Employee>> sortByNameAndAgeAndSalary() {
        return Comparator.comparing((Map.Entry<String, Employee> e)->e.getValue().getName())
                .thenComparing(e->e.getValue().getAge())
                .thenComparing(e->e.getValue().getSalary());
    }

    public static Comparator<Map.Entry<String, Employee>> getSortingByMapKey() {
        return Comparator.comparing(Map.Entry::getKey);
    }
    public static Map<String, Employee> sortMapByComparator(Map<String, Employee> map, Comparator<Map.Entry<String, Employee>> comparator) {
        return  map.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue)-> oldValue,
                        LinkedHashMap::new));
    }
}
