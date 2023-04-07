package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        Windows.getInstance().dashboard().show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}


