package com.krish.jpa_querydsl.immutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutableTester {
    public static void main(String[] args) {
        nonImmutableExample();
        System.out.println("--------------");
        immutableExample();
        System.out.println("--------------");
        immutableExample2();
        System.out.println("--------------");
        immutableExample3();
    }

    private static void nonImmutableExample() {
        Address address = new Address("addressLine", "HYD","TG","500020", "IND");
        System.out.println(address.getAddressLine());
        PersonNonImmutable p1 = new PersonNonImmutable("Krishna", "Punna", address);
        System.out.println(p1.getFirstName());
        p1.setFirstName("Aadhya");
        System.out.println(p1.getFirstName());
    }

    private static void immutableExample() {
        Address address = new Address("addressLine", "HYD","TG","500020", "IND");
        System.out.println(address.getAddressLine());
        PersonImmutable p1 = new PersonImmutable("Krishna", "Punna", address);
        System.out.println(p1.getFirstName());
        System.out.println(p1.getAddress().getAddressLine());
        p1.getAddress().setAddressLine("BGLR");
        System.out.println(p1.getAddress().getAddressLine());
    }

    private static void immutableExample2() {
        Address address1 = new Address("addressLine1", "HYD","TG","500020", "IND");
        Address address2 = new Address("addressLine2", "BGLR","KR","600020", "IND");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        Person p1 = new Person("Krishna", addresses);
        System.out.println(p1.getAddresses().get(0).getAddressLine());
        p1.getAddresses().get(0).setAddressLine("DLH");
        System.out.println(p1.getAddresses().get(0).getAddressLine());
    }

    private static void immutableExample3() {
        AddressDTO address1 = new AddressDTO("addressLine1", "HYD","TG","500020", "IND");
        AddressDTO address2 = new AddressDTO("addressLine2", "BGLR","KR","600020", "IND");
        List<AddressDTO> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        PersonFullImmutable p1 = new PersonFullImmutable("Krishna", addresses);
        System.out.println("ex-3: "+p1.getAddresses().get(0).getAddressLine());
//        p1.getAddresses().get(0).setAddressLine("DLH");
        System.out.println("ex-3: "+p1.getAddresses().get(0).getAddressLine());
    }
}
