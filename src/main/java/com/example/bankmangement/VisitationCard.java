package com.example.bankmangement;


import javafx.scene.image.Image;

import java.io.Serializable;

public class VisitationCard implements Serializable {
    private Integer customerID;
    private Integer boxNumber;
    private String visitDate;
    private String visitTime;

    private ImageData signatureImageData;
    private ImageData attendantSignatureImageData;
    private Boolean asDeputy;
    private String description;

    public VisitationCard(
            Integer customerID,
            Integer boxNumber,
            String visitDate,
            String visitTime,
            Image singnatureImage,
            Image attendantSignature,
            Boolean asDeputy,
            String description)
    {
        this.customerID = customerID;
        this.boxNumber = boxNumber;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.signatureImageData = new ImageData(singnatureImage);
        this.attendantSignatureImageData = new ImageData(attendantSignature);
        this.asDeputy = asDeputy;
        this.description = description;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public Image getSingnatureImage() {
        return signatureImageData.getImage();
    }

    public void setSingnatureImageData(ImageData imageData) {
        this.signatureImageData = imageData;
    }

    public Image getAttendantSignature() {
        return attendantSignatureImageData.getImage();
    }

    public void setAttendantSignature(ImageData attendantSignature) {
        this.attendantSignatureImageData = attendantSignature;
    }

    public Boolean getAsDeputy() {
        return asDeputy;
    }

    public void setAsDeputy(Boolean asDeputy) {
        this.asDeputy = asDeputy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VisitationCard(){

        //this no argument contrcutor will be created empty object
        //when we find a object by it field
    }
}
