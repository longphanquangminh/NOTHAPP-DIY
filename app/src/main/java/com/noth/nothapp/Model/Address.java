package com.noth.nothapp.Model;

public class Address {
    private String nameUser;
    private String phoneNum;
    private String address;

    public Address(String nameUser, String phoneNum, String address) {
        this.nameUser = nameUser;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public Address() {

    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}