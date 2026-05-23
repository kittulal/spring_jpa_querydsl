package com.krish.jpa_querydsl.immutable;

public class AddressDTO extends com.krish.jpa_querydsl.immutable.Address {
    AddressDTO(){
        super();
    }
    AddressDTO(String addressLine, String city, String state, String zipcode, String country) {
        super(addressLine, city, state, zipcode, country);
    }
    //Override all setter ethods with private method, to restrict
    public void setAddressLine(String addressLine) {
        throw new UnsupportedOperationException();
    }
    public void setCity(String city) {
        throw new UnsupportedOperationException();
    }
    public void setState(String state) {
        throw new UnsupportedOperationException();
    }
    public void setZipcode(String zipcode) {
        throw new UnsupportedOperationException();
    }
    public void setCountry(String country){
        throw new UnsupportedOperationException();
    }

}
