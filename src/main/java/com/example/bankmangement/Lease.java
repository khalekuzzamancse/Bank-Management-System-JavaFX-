package com.example.bankmangement;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Lease implements Serializable {
    private Integer lesseeID;
    private Integer customerID;
    private Integer depositAmount;
    private BufferedImage customerSignature;

    private Integer boxNumber;
    private String rentDate;
    private String expireDate;
    private Boolean hasDeputy;
    private String deputyName;
    private String deputyAddress;
    private String deputyPhoneNumber;
    private Image deputySignature;
    private Integer agreementID;

    public Lease(Integer customerID,
                 Integer depositAmount,
                 BufferedImage customerSignature,
                 Integer boxNumber,
                 String rentDate,
                 String expireDate) {
        this.customerID = customerID;
        this.depositAmount = depositAmount;
        this.customerSignature = customerSignature;
        this.boxNumber = boxNumber;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
        this.hasDeputy = false;
        this.lesseeID = (int) (Math.random() * (10000 - 10 + 1) + 100);
    }

    public Lease(Integer customerID,
                 Integer depositAmount,
                 BufferedImage customerSignature,
                 Integer boxNumber, String rentDate,
                 String expireDate, String deputyName, String deputyAddress,
                 String deputyPhoneNumber, Image deputySignature
    ) {
        this.customerID = customerID;
        this.depositAmount = depositAmount;
        this.customerSignature = customerSignature;
        this.boxNumber = boxNumber;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
        this.deputyName = deputyName;
        this.deputyAddress = deputyAddress;
        this.deputyPhoneNumber = deputyPhoneNumber;
        this.deputySignature = deputySignature;
        this.hasDeputy = true;
        this.lesseeID = (int) (Math.random() * (10000 - 10 + 1) + 100);
    }

    public Integer getLesseeID() {
        return lesseeID;
    }

    public void setLesseeID(Integer lesseeID) {
        this.lesseeID = lesseeID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Integer depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BufferedImage getCustomerSignature() {
        return customerSignature;
    }

    public void setCustomerSignature(BufferedImage customerSignature) {
        this.customerSignature = customerSignature;
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean getHasDeputy() {
        return hasDeputy;
    }

    public void setHasDeputy(Boolean hasDeputy) {
        this.hasDeputy = hasDeputy;
    }

    public String getDeputyName() {
        return deputyName;
    }

    public void setDeputyName(String deputyName) {
        this.deputyName = deputyName;
    }

    public String getDeputyAddress() {
        return deputyAddress;
    }

    public void setDeputyAddress(String deputyAddress) {
        this.deputyAddress = deputyAddress;
    }

    public String getDeputyPhoneNumber() {
        return deputyPhoneNumber;
    }

    public void setDeputyPhoneNumber(String deputyPhoneNumber) {
        this.deputyPhoneNumber = deputyPhoneNumber;
    }

    public Image getDeputySignature() {
        return deputySignature;
    }

    public void setDeputySignature(Image deputySignature) {
        this.deputySignature = deputySignature;
    }

    public Integer getAgreementID() {
        return agreementID;
    }

    public void setAgreementID(Integer agreementID) {
        this.agreementID = agreementID;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "lesseeID=" + lesseeID +
                ", customerID=" + customerID +
                ", depositAmount=" + depositAmount +
                ", customerSignature=" + customerSignature +
                ", boxNumber=" + boxNumber +
                ", rentDate='" + rentDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", hasDeputy=" + hasDeputy +
                ", deputyName='" + deputyName + '\'' +
                ", deputyAddress='" + deputyAddress + '\'' +
                ", deputyPhoneNumber='" + deputyPhoneNumber + '\'' +
                ", deputySignature=" + deputySignature +
                ", agreementID=" + agreementID +
                '}';
    }
}
