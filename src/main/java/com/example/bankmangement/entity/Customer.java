package com.example.bankmangement.entity;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Random;

public class Customer implements Serializable {
    private String name;
    private String email;
    private String phoneNumber;
    private String firm;
    private String address;
    private String eyeColor;
    private String hairColor;
    private String height;
    private String weight;
    private Double balance;
    private int userID;

    public Customer(String name, String email, String phoneNumber, String firm, String address, String eyeColor,
                    String hairColor, String height, String weight, Double balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firm = firm;
        this.address = address;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
        this.balance = balance;
        this.userID = generateUserID();
    }

    // getter and setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getFirm() {
        return firm;
    }
    public void setFirm(String firm) {
        this.firm = firm;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEyeColor() {
        return eyeColor;
    }
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public int getUserID() {
        return userID;
    }

    // method to generate random user ID
    private int generateUserID() {
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firm='" + firm + '\'' +
                ", address='" + address + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", balance=" + balance +
                ", userID=" + userID +
                '}';
    }
    public Customer(){
        //this no argument contrcutor will be created empty object
        //when we find a object by it field
    }
}
