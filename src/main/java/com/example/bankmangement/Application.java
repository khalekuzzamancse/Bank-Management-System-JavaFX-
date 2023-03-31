package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bank Management System");

//        FXMLLoader fxmlLoader =
//                new FXMLLoader(Application.class.getResource("/layout/customer_view.fxml"));
        FXMLLoader fxmlLoader =
                new FXMLLoader(Application.class.getResource(Layouts.VIWES));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

//        // prevent the user from resizing the window
//        stage.setMinWidth(400);
//        stage.setMinHeight(300);
        stage.sizeToScene();
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}


