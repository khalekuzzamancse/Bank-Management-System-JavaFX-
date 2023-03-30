package com.example.bankmangement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

}
