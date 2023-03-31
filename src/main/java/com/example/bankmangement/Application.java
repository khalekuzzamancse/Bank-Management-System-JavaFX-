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
                new FXMLLoader(Application.class.getResource("/layout/visitation_card.fxml"));
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

//        DemoData.addDemoData();
//        DemoData.printAllTable();
//           DemoData.addCustomer();
        //    DemoData.addCustomer();
        //DemoData.readCustomers();


    }

    public static void main(String[] args) {
        launch(args);
    }

}


