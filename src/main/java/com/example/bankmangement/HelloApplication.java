package com.example.bankmangement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bank Management System");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/layout/deputy_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);


//        // prevent the user from resizing the window
//        stage.setMinWidth(400);
//        stage.setMinHeight(300);
//
//        //stage.setScene(new LoginScreen().getScene());
//        stage.setScene(new AddAccountScreen(stage).getScene());
        //  stage.setScene(new AddBoxScreen().getScene());
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
