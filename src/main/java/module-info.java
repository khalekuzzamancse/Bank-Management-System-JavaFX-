module com.example.bankmangement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankmangement to javafx.fxml;
    exports com.example.bankmangement;
    exports com.example.bankmangement.entity;
    opens com.example.bankmangement.entity to javafx.fxml;
}