package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
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


//        Lease lease1 = new Lease(123, 500, null, 1, "2022-01-01", "2023-01-01");
//        Lease lease2 = new Lease(456, 750, null, 2, "2022-03-15", "2023-03-15", "John Doe", "123 Main St", "555-1234", null);
//        Lease lease3 = new Lease(789, 1000, null, 3, "2022-06-30", "2023-06-30");
//
//        List<Lease> leases = new ArrayList<>();
////        leases.add(lease1);
////        leases.add(lease2);
////        leases.add(lease3);
//        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
//        System.out.println(bImage.getHeight());
//
//        leases.add(new Lease(111, 500,null,
//                1, "2022-01-01", "2023-01-01"));
//        LeaseFao.writeToFile(leases);
        //LeaseFao.readFromFile();
        // System.out.println(LeaseFao.readFromFile());

        // Create a list of images to serialize

        // Image image = new Image("path/to/image.png");
        ImageData imageData = new ImageData(image1);
        X x = new X(1, imageData);

        String filename = "x.ser";
        // writeObjectToFile(x,filename);

        //  System.out.println(readObjectFromFile(filename).getImageData().getImage().getHeight());
        List<X> xList = new ArrayList<>();
        xList.add(new X(1, imageData));
        xList.add(new X(2, imageData));
        // SerializationUtils.writeListToFile(xList, "lists.ser");
//        List<X> newXList = SerializationUtils.readListFromFile("lists.ser");
//
//        for (X it : xList) {
//            System.out.println(it.getId()+"  ,"+it.getImageData().getImage().getHeight());
//        }

//        writeRentToFile(new Rent(1, 1, image1,
//                1, "1", "1"), "r.ser");

        List<Rent> rentList = new ArrayList<>();
        rentList.add(
                new Rent(1, 1, image1,
                        1, "1", "1"));
        // LeaseFao.writeToFile(rentList);
        LeaseFao.addToTable(new Rent(10, 1, image1,
                1, "1", "1"));


        Image image2 = new Image(getClass().getResource("/Images/" + "images.png").toExternalForm());
//        LeaseFao.addToTable(new Rent(23, 1, image2,
//                1, "1", "1"));
//
//        LeaseFao.addToTable(new Rent(45, 1, image1,
//                1, "1", "1", "na", "2", "3", image2));


        List<Rent> list = LeaseFao.readFromFile();

        for (Rent it : list) {
            if(it.getHasDeputy())
            {
                System.out.println(it.getDeputySignature().getHeight());
            }
            System.out.println(it.getCustomerID() + "  ," + it.getCustomerSignature().getHeight());
        }


        // System.out.println(readRentFromFile("r.ser").getCustomerSignature().getHeight());


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

    public static X readObjectFromFile(String filePath) {
        X x = null;
        try (FileInputStream fileInStream = new FileInputStream(filePath);
             ObjectInputStream objInStream = new ObjectInputStream(fileInStream)) {
            x = (X) objInStream.readObject();
            System.out.println("Read Sucess");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return x;
    }

    public static void writeObjectToFile(X x, String filePath) {
        try (FileOutputStream fileOutStream = new FileOutputStream(filePath);
             ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream)) {
            objOutStream.writeObject(x);
            System.out.println("wrie sucess");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRentToFile(Rent x, String filePath) {
        try (FileOutputStream fileOutStream = new FileOutputStream(filePath);
             ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream)) {
            objOutStream.writeObject(x);
            System.out.println("wrie sucess");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Rent readRentFromFile(String filePath) {
        Rent x = null;
        try (FileInputStream fileInStream = new FileInputStream(filePath);
             ObjectInputStream objInStream = new ObjectInputStream(fileInStream)) {
            x = (Rent) objInStream.readObject();
            System.out.println("Read Sucess");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return x;
    }
}


