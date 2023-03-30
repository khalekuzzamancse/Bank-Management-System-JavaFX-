module com.example.bankmangement {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;


    opens com.example.bankmangement to javafx.fxml;
    exports com.example.bankmangement;
    exports com.example.bankmangement.entity;
    opens com.example.bankmangement.entity to javafx.fxml;
    exports com.example.bankmangement.controller;
    opens com.example.bankmangement.controller to javafx.fxml;
}