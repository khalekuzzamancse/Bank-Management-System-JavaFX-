package com.example.bankmangement.entity;

import javafx.scene.image.Image;

import java.io.Serializable;

public class HistoryCard implements Serializable {
    private Integer boxNumber;
    private Integer customerID;
    private String rentDate;
    private ImageData attendantSignatureImageData;

    public HistoryCard(Integer boxNumber, Integer customerID, String rentDate, Image attendantSignature) {
        this.boxNumber = boxNumber;
        this.customerID = customerID;
        this.rentDate = rentDate;
        this.attendantSignatureImageData = new ImageData(attendantSignature);
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public Image getAttendantSignature() {
        return attendantSignatureImageData.getImage();
    }

    public void setAttendantSignatureImageData(ImageData attendantSignatureImageData) {
        this.attendantSignatureImageData = attendantSignatureImageData;
    }
    public HistoryCard(){

            //this no argument contrcutor will be created empty object
            //when we find a object by it field
    }
}
