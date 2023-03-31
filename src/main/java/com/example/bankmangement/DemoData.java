package com.example.bankmangement;

import javafx.scene.image.Image;

public class DemoData {
    public static void addData() {
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

}
