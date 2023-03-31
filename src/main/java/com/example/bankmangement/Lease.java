package com.example.bankmangement;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Random;

public class Lease implements Serializable {
    private Integer id;
    private ImageData customerSignetureimageData;

    private Integer lesseeID;
    private Integer customerID;
    private Integer depositAmount;
    private transient Image customerSignature;

    private Integer boxNumber;
    private String rentDate;
    private String expireDate;
    private Boolean hasDeputy;
    private String deputyName;
    private String deputyAddress;
    private String deputyPhoneNumber;

    private transient Image deputySignature;
    private ImageData deputySignetureimageData;
    private Integer agreementID;

    public Lease(
            Integer customerID,
            Integer depositAmount,
            Image customerSignature,
            Integer boxNumber,
            String rentDate,
            String expireDate) {
        this.lesseeID = getAgreementID();
        this.id = getAgreementID();
        this.customerID = customerID;
        this.depositAmount = depositAmount;
        this.customerSignature = customerSignature;
        this.boxNumber = boxNumber;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
        this.hasDeputy = false;
        this.lesseeID = (int) (Math.random() * (10000 - 10 + 1) + 100);
        this.customerSignetureimageData = new ImageData(customerSignature);
    }

    public Lease(
            Integer customerID,
            Integer depositAmount,
            Image customerSignature,
            Integer boxNumber,
            String rentDate,
            String expireDate,
            String deputyName,
            String deputyAddress,
            String deputyPhoneNumber,
            Image deputySignature
    ) {
        this.lesseeID = getAgreementID();
        this.id = getAgreementID();
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
        this.customerSignetureimageData = new ImageData(customerSignature);
        this.deputySignetureimageData = new ImageData(deputySignature);

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

    public Image getCustomerSignature() {
        return customerSignetureimageData.getImage();
    }

    public void setCustomerSignature(Image customerSignature) {
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

        return deputySignetureimageData.getImage();
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

//    public Rent(Integer id, ImageData imageData) {
//        this.id = id;
//        this.imageData = imageData;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public ImageData getImageData() {
//        return imageData;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public void setImageData(ImageData imageData) {
//        this.imageData = imageData;
//    }

    @Override
    public String toString() {
        return "Lease{" +
                "id=" + id +
                ", lesseeID=" + lesseeID +
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

    private int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}

