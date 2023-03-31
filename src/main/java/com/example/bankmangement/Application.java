package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bank Management System");
        Parent firstRoot = FXMLLoader.load(getClass().getResource(Layouts.LEASE_AGREEMENT));
        Scene firstScene = new Scene(firstRoot);

        // Create the first stage
        Stage firstStage = new Stage();
        firstStage.setTitle("Lease Agreement");
        firstStage.setScene(firstScene);
        firstStage.sizeToScene();
        firstStage.setMinWidth(600);
        firstStage.setMinHeight(300);
        firstStage.show();

        Parent secondRoot = FXMLLoader.load(getClass().getResource(Layouts.VIWES));
        Scene secondScene = new Scene(secondRoot);

        // Create the second stage
        Stage secondStage = new Stage();
        secondStage.setTitle("Second Stage");
        secondStage.setScene(secondScene);
        secondStage.sizeToScene();
        secondStage.setMinWidth(1000);
        secondStage.setMinHeight(300);
        secondStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}


