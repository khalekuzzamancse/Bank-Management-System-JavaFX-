package com.example.bankmangement.entity;

public class ExpireUser {
    private Integer customerID;
    private String email;
    private String expireDate;
    private String name;
    private Integer boxNumber;

    public ExpireUser(int customerID, String name, String email, Integer boxNumber, String expireDate) {
        this.customerID = customerID;
        this.email = email;
        this.expireDate = expireDate;
        this.name = name;
        this.boxNumber = boxNumber;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    @Override
    public String toString() {
        return "ExpireUser{" +
                "customerID=" + customerID +
                ", email='" + email + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", name='" + name + '\'' +
                ", boxNumber=" + boxNumber +
                '}';
    }
}
