package com.xzm.bean;

public class Address {
    private Long addressId = null;

    private String name = null;


    public Address(Long addressId, String name) {
        this.addressId = addressId;
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
