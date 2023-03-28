module com.example.bankmangement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankmangement to javafx.fxml;
    exports com.example.bankmangement;
}