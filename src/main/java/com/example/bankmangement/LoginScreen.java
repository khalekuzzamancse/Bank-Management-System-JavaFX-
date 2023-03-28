package com.example.bankmangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginScreen {
    @FXML
    private final TextField usernameField;
    @FXML
    private final PasswordField passwordField;
    @FXML
    private final Button loginButton;
    @FXML
    private  Label errorLabel;
    Scene scene;

    public LoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        loader.setController(this);
        Parent root;
        root = loader.load();
        scene = new Scene(root, 320, 500);
        loginButton = (Button) scene.lookup("#loginButton");
        loginButton.setOnAction(this::handleLogin);
        usernameField = (TextField) scene.lookup("#usernameField");
        passwordField = (PasswordField) scene.lookup("#passwordField");

    }

    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println(username + "," + password);
    }
    public Scene getScene() {
        return scene;
    }
}
