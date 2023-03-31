package com.example.bankmangement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class AddBoxScreen {
    private TextField heightTextField;
    private TextField widthTextField;
    private TextField idTextField;
    private TextField oldPriceTextField;
    private TextField newPriceTextField;
    private TextField amountTextField;
    private Button addButton;
    Scene scene;
    private GridPane container;

    public AddBoxScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/add_box_layout.fxml"));
        loader.setController(this);
        Parent root;
        root = loader.load();
        scene = new Scene(root);
        initialize();

        container = (GridPane) scene.lookup("#container");

        container.setLayoutX((scene.getWidth() - container.getWidth()) / 2);
        // center the label vertically
        container.setLayoutY((scene.getHeight() - container.getHeight()) / 2);
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            // center the label horizontally
            container.setLayoutX((newVal.doubleValue() - container.getWidth()) / 2);
        });
        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            // center the label vertically
            container.setLayoutY((newVal.doubleValue() - container.getHeight()) / 2);
        });


    }

    private void initialize() {
        heightTextField = (TextField) scene.lookup("#heightTextField");
        widthTextField = (TextField) scene.lookup("#widthTextField");
        idTextField = (TextField) scene.lookup("#idTextField");
        oldPriceTextField = (TextField) scene.lookup("#oldPriceTextField");
        newPriceTextField = (TextField) scene.lookup("#newPriceTextField");
        amountTextField = (TextField) scene.lookup("#amountTextField");
        addButton = (Button) scene.lookup("#addButton");
        addButton.setOnAction(this::onAddClick);
    }

    private void onAddClick(ActionEvent event) {
        String height = heightTextField.getText();
        String width = widthTextField.getText();
        String id = idTextField.getText();
        String oldPrice = oldPriceTextField.getText();
        String newPrice = newPriceTextField.getText();
        String amount = amountTextField.getText();
        System.out.println(
                "height" + ": " + height +
                        "width" + ": " + width +
                        "id" + ": " + id +
                        "oldPrice" + ": " + oldPrice +
                        "newPrice" + ": " + newPrice +
                        "amount" + ": " + amount
        );
    }

    public Scene getScene() {
        return scene;
    }
}
