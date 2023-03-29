package com.example.bankmangement.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DeputyFormController implements Initializable {


    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button addButton;

    @FXML
    private void handleSubmit() {
        String name = nameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
