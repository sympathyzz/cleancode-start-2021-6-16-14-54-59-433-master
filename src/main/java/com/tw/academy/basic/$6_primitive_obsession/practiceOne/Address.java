package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public String getCity() {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    public String getProvince() {
        return address.substring(0, address.indexOf("省"));
    }
}
