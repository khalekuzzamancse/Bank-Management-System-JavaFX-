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

        //  Image image = new Image(getClass().getResource("/Images/" + "customer_signature.png").toExternalForm());
        Image image1 = new Image(getClass().getResource("/Images/" + "customer_signature.png").toExternalForm());
        Image image2 = new Image(getClass().getResource("/Images/" + "images.png").toExternalForm());

        Fao.write("LeaseTable.dat", new Lease(23, 1, image2,
                1, "1", "1"));
        Fao.write("LeaseTable.dat", new Lease(45, 1, image1,
                1, "1", "1", "na", "2",
                "3", image2));

        List<Lease> list = Fao.read("LeaseTable.dat");

        System.out.println(list.size());

        for (Lease it : list) {
            System.out.println(it.getCustomerID() + "  ," + it.getCustomerSignature().getHeight());
        }


    }

    public static void main(String[] args) {
        launch(args);
    }


    public static void writeRentToFile(Lease x, String filePath) {
        try (FileOutputStream fileOutStream = new FileOutputStream(filePath);
             ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream)) {
            objOutStream.writeObject(x);
            System.out.println("wrie sucess");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Lease readRentFromFile(String filePath) {
        Lease x = null;
        try (FileInputStream fileInStream = new FileInputStream(filePath);
             ObjectInputStream objInStream = new ObjectInputStream(fileInStream)) {
            x = (Lease) objInStream.readObject();
            System.out.println("Read Sucess");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return x;
    }
}


