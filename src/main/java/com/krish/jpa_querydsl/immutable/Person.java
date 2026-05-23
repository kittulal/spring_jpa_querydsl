package com.krish.jpa_querydsl.immutable;

import java.util.Collections;
import java.util.List;

public class Person {
    private String firstName;
    private List<Address> addresses;
    public Person(String firstName, List<Address> addresses) {
        this.firstName = firstName;
        this.addresses = addresses;
    }

    public String getFirstName() {
        return firstName;
    }
    public List<Address> getAddresses() {
//        return addresses;
        return Collections.unmodifiableList(addresses);
    }
}
