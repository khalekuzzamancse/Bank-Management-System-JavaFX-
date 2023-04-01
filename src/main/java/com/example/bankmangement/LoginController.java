package com.example.bankmangement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public AnchorPane parent;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    private GridPane container;

    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println(username + "," + password);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        container.sceneProperty().addListener((observable, oldValue, scene) -> {
            if (scene != null) {
                //when the scene is not null
                //then we align the content is center
               alignUIElementToCenter(scene);
            }
        });

    }

    private void alignUIElementToCenter(Scene scene) {
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
}
