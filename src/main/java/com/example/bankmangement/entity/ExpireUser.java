package com.example.bankmangement.entity;

public class ExpireUser {
    private Integer customerID;
    private String email;
    private String expireDate;

    public ExpireUser(Integer customerID, String email, String expireDate) {
        this.customerID = customerID;
        this.email = email;
        this.expireDate = expireDate;
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
}
