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
import javafx.scene.layout.GridPane;

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
    private GridPane container;

    public LoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/login_layout.fxml"));

        loader.setController(this);
        Parent root;
        root = loader.load();

        scene = new Scene(root);
        loginButton = (Button) scene.lookup("#loginButton");
        loginButton.setOnAction(this::handleLogin);
        usernameField = (TextField) scene.lookup("#usernameField");
        passwordField = (PasswordField) scene.lookup("#passwordField");


        //centering the content
        container =(GridPane) scene.lookup("#container");

        container.setLayoutX((scene.getWidth() - container.getWidth()) / 2);
        // center the label vertically
        container.setLayoutY((scene.getHeight() - container.getHeight()) / 2);
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            // center the label horizontally
            container.setLayoutX((newVal.doubleValue() - container.getWidth()) / 2);
        });
        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            // center the label vertically
            container.setLayoutY((newVal.doubleValue() - container.getHeight()) / 2);
        });


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
