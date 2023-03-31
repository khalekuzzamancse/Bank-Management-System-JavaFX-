package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bank Management System");

        FXMLLoader fxmlLoader =
                new FXMLLoader(Application.class.getResource("/layout/lease_form.fxml"));
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

       DemoData.addData();

//        List<HistoryCard> list = Fao.read("HistoryCard.dat");
//
//        System.out.println(list.size());
//
//        for (HistoryCard it : list) {
//            System.out.println(it);
//        }


    }

    public static void main(String[] args) {
        launch(args);
    }

}


