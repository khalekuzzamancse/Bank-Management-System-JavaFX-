package com.example.bankmangement;

import javafx.scene.image.Image;

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


}
