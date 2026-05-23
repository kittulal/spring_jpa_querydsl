package com.krish.jpa_querydsl.immutable;

public class PersonImmutable {
    private String firstName;
    private String lastName;
    private Address address;
    public PersonImmutable(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        Address addressImm = new Address(address.getAddressLine(), address.getCity(), address.getState(), address.getZip(), address.getCountry());
        return addressImm;
    }
}
