package com.example.bankmangement.controller;

import com.example.bankmangement.entity.Deputy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DeputyViewController implements Initializable {
    @FXML
    private AnchorPane tableContainer;
    @FXML
    private TableView<Deputy> table;
    @FXML
    private TableColumn<Deputy, Integer> idColumn;
    @FXML
    private TableColumn<Deputy, String> nameColumn;
    @FXML
    private TableColumn<Deputy, String> addressColumn;
    @FXML
    private TableColumn<Deputy, String> phoneColumn;

    private final ObservableList<Deputy> list = FXCollections.observableArrayList(
            new Deputy(1, "Abul", "Jashore", "01738813865")

    );

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(list);

        table.setLayoutX((tableContainer.getWidth() - tableContainer.getWidth()) / 2);
        // center the label vertically
        table.setLayoutY((tableContainer.getHeight() - tableContainer.getHeight()) / 2);
        tableContainer.widthProperty().addListener((obs, oldVal, newVal) -> {
            // center the label horizontally
            table.setLayoutX((newVal.doubleValue() - table.getWidth()) / 2);
        });
        tableContainer.heightProperty().addListener((obs, oldVal, newVal) -> {
            // center the label vertically
            table.setLayoutY((newVal.doubleValue() - table.getHeight()) / 2);
        });


    }
}
