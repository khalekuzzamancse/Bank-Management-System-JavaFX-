package com.example.bankmangement.controller;

import com.example.bankmangement.entity.Customer;
import com.example.bankmangement.utils.Fao;
import com.example.bankmangement.constants.TableName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAccountScreen implements Initializable {


    @FXML
    private TextField balanceTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField addressTextField;
    private Scene scene;
    @FXML
    private GridPane container;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;

    @FXML
    private TextField hairColorTextField;
    @FXML
    private TextField eyeColorTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField firmTextField;

    @FXML
    private Button addButton;

    private Stage stage;

//    public AddAccountScreen(Stage stage) throws IOException {
//        //centering the content
//        container = (GridPane) scene.lookup("#container");
//
//        container.setLayoutX((scene.getWidth() - container.getWidth()) / 2);
//        // center the label vertically
//        container.setLayoutY((scene.getHeight() - container.getHeight()) / 2);
//        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
//            // center the label horizontally
//            container.setLayoutX((newVal.doubleValue() - container.getWidth()) / 2);
//        });
//        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
//            // center the label vertically
//            container.setLayoutY((newVal.doubleValue() - container.getHeight()) / 2);
//        });
//
//
//    }

    @FXML
    private void onAddClick(ActionEvent event) {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String phoneNumber = phoneTextField.getText();
        String firm = firmTextField.getText();
        String address = addressTextField.getText();
        String eyeColor = eyeColorTextField.getText();
        String hairColor = hairColorTextField.getText();
        String height = heightTextField.getText();
        String weight = weightTextField.getText();
        String balance = balanceTextField.getText();
        Customer customer = new Customer(name, email, phoneNumber, firm, address, eyeColor, hairColor,
                height, weight, Double.parseDouble(balance));
        insertToDatabase(customer);
         System.out.printf(customer.toString());
//        System.out.println(
//                "name" + ":" + name + "\n" +
//                        "email" + ":" + email + "\n" +
//                        "phone" + ":" + phoneNumber + "\n" +
//                        "firm" + ":" + firm + "\n" +
//                        "eyeColor" + ":" + eyeColor + "\n" +
//                        "hairColor" + ":" + hairColor + "\n" +
//                        "height" + ":" + height + "\n" +
//                        "weight" + ":" + weight + "\n" +
//                        "balance" + ":" + balance + "\n"+
//                        "addrees"+":"+address
//        );

    }

//    private void onDeputySignetureImageSelected(MouseEvent mouseEvent) {
//        FileChooser.ExtensionFilter imageFilter =
//                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
//        fileChooser.getExtensionFilters().add(imageFilter);
//        File selectedFile = fileChooser.showOpenDialog(stage);
//        if (selectedFile != null) {
//            Image image = new Image(selectedFile.toURI().toString());
//            deputySignatureImageView.setImage(image);
//        }
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void insertToDatabase(Customer customer) {
        Fao.write(TableName.CUSTOMER_TABLE, customer);
    }
}
