package com.example.bankmangement;

import com.example.bankmangement.entity.Box;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BoxViewController implements Initializable {
    @FXML
    private TableView<Box> table;
    @FXML
    private TableColumn<Box, Integer> boxIDColumn;
    @FXML
    private TableColumn<Box, Integer> heightColumn;
    @FXML
    private TableColumn<Box, Integer> widthColumn;
    @FXML
    private TableColumn<Box, Integer> oldPriceColumn;
    @FXML
    private TableColumn<Box, Integer> newPriceColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxIDColumn.setCellValueFactory(new PropertyValueFactory<Box, Integer>("boxID"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<Box, Integer>("height"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<Box, Integer>("width"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<Box, Integer>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<Box, Integer>("newPrice"));

    }
}
