package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
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

        //  Image image = new Image(getClass().getResource("/Images/" + "customer_signature.png").toExternalForm());
        Image image = new Image(getClass().getResource("/Images/" + "customer_signature.png").toExternalForm());


        Lease lease1 = new Lease(123, 500, null, 1, "2022-01-01", "2023-01-01");
        Lease lease2 = new Lease(456, 750, null, 2, "2022-03-15", "2023-03-15", "John Doe", "123 Main St", "555-1234", null);
        Lease lease3 = new Lease(789, 1000, null, 3, "2022-06-30", "2023-06-30");

        List<Lease> leases = new ArrayList<>();
        leases.add(lease1);
        leases.add(lease2);
        leases.add(lease3);
      //  LeaseFao.writeToFile(leases);
        LeaseFao.readFromFile();

    }


    public static void main(String[] args) {
        launch(args);
    }

    void readImage() {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File("image.png"));
            System.out.println("Successfully read Image from file.");
        } catch (IOException e) {
            System.out.println("Error reading Image from file: " + e.getMessage());
        }

        // convert BufferedImage to Image
        Image image = SwingFXUtils.toFXImage(bImage, null);
        System.out.println(image.getHeight());
    }

    void writeImage(Image image) {
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        File outputFile = new File("image.png");
        try {
            ImageIO.write(bImage, "png", outputFile);
            System.out.println("Successfully saved Image to file.");
        } catch (IOException e) {
            System.out.println("Error saving Image to file: " + e.getMessage());
        }
    }
}
