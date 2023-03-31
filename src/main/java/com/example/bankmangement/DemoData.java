package com.example.bankmangement;

import com.example.bankmangement.entity.BoxModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class DemoData {
    public static void addDemoData() {
        // Image image1 = new Image(getClass().getResource("/images/" + "customer_signature.png").toExternalForm());
        Image image1 = new Image(DemoData.class.getResource("/images/" + "customer_signature.png").toExternalForm());
        Image image2 = new Image(DemoData.class.getResource("/images/" + "images.png").toExternalForm());
        Fao.write(TableName.VISITATION_CARD_TABLE, new VisitationCard(1, 1, "1", "1",
                image1, image2, true, "des"));
        Fao.write(TableName.HISTORY_CARD_TABLE, new HistoryCard(1, 1, "1", image1));

        Fao.write(TableName.LEASE_TABLE, new Lease(23, 1, image2, 1, "1", "1"));

        Fao.write(TableName.LEASE_TABLE, new Lease(45, 1, image1, 1, "1", "1",
                "na", "2", "3", image2));
    }

    public static void printHistoryCardTable() {
        List<HistoryCard> list = Fao.read(TableName.HISTORY_CARD_TABLE);
        System.out.println(TableName.HISTORY_CARD_TABLE + " size :" + list.size());
        for (HistoryCard it : list) {
            System.out.println(it);
        }
    }

    public static void printVisitCardTable() {
        List<VisitationCard> list = Fao.read(TableName.VISITATION_CARD_TABLE);
        System.out.println(TableName.VISITATION_CARD_TABLE + " size :" + list.size());
        for (VisitationCard it : list) {
            System.out.println(it);
        }
    }

    public static void printLeaseTable() {
        List<Lease> list = Fao.read(TableName.LEASE_TABLE);
        System.out.println(TableName.LEASE_TABLE + " size :" + list.size());
        for (Lease it : list) {
            System.out.println(it);
        }
    }

    public static void addCustomer() {
        Customer customer1 = new Customer("John Doe", "johndoe@example.com", "555-555-5555", "ABC Company",
                "123 Main St", "Brown", "Black", "6'2\"", "180 lbs", 1000.0);
        Fao.write(TableName.CUSTOMER_TABLE, customer1);
        Customer customer2 = new Customer("Jane Smith", "janesmith@example.com", "555-555-5556", "XYZ Corporation",
                "456 Elm St", "Blue", "Blonde", "5'7\"", "150 lbs", 2500.0);
        Fao.write(TableName.CUSTOMER_TABLE, customer2);
        Customer customer3 = new Customer("Bob Johnson", "bjohnson@example.com", "555-555-5557", "Acme Corp",
                "789 Maple Ave", "Green", "Brown", "5'11\"", "200 lbs", 500.0);
        Fao.write(TableName.CUSTOMER_TABLE, customer3);
        Customer customer4 = new Customer("Samantha Lee", "samlee@example.com", "555-555-5558", "123 Industries",
                "321 Oak St", "Hazel", "Red", "5'5\"", "120 lbs", 1500.0);
        Fao.write(TableName.CUSTOMER_TABLE, customer4);
        Customer customer5 = new Customer("Tom Wilson", "twilson@example.com", "555-555-5559", "GHI Enterprises",
                "987 Pine Rd", "Gray", "Salt-and-Pepper", "6'0\"", "175 lbs", 750.0);
        Fao.write(TableName.CUSTOMER_TABLE, customer5);
    }

    public static void readCustomers() {
        List<Customer> list = Fao.read(TableName.CUSTOMER_TABLE);
        System.out.println(TableName.CUSTOMER_TABLE + " size :" + list.size());
        for (Customer it : list) {
            System.out.println(it);
        }
    }

    public static void printAllTable() {
        printLeaseTable();
        System.out.println("------------------");
        System.out.println("\n");

        printHistoryCardTable();
        System.out.println("------------------");
        System.out.println("\n");

        printVisitCardTable();
        System.out.println("------------------");
        System.out.println("\n");

    }

    public static List<BoxModel> getBoxList() {
        return (FXCollections.observableArrayList(
                new BoxModel(1, 3, 5, 10, 25),
                new BoxModel(2, 5, 5, 25, 45),
                new BoxModel(3, 3, 10, 30, 75),
                new BoxModel(4, 5, 10, 40, 100)
        ));
    }


}
