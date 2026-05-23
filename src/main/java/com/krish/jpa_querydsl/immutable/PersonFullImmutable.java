package com.krish.jpa_querydsl.immutable;

import java.util.Collections;
import java.util.List;

public class PersonFullImmutable {
    private String name;
    private List<AddressDTO> addresses;

    PersonFullImmutable(String name, List<AddressDTO> addresses){
        this.name = name;
        this.addresses = addresses;
    }
    public String getName() {
        return name;
    }
    public List<AddressDTO> getAddresses() {
        return Collections.unmodifiableList(addresses);
    }
}
