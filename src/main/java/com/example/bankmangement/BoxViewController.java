package com.example.bankmangement;

import com.example.bankmangement.entity.BoxModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BoxViewController implements Initializable {
    @FXML
    private AnchorPane tableContainer;

    @FXML
    private TableView<BoxModel> table;
    @FXML
    private TableColumn<BoxModel, Integer> boxIDColumn;
    @FXML
    private TableColumn<BoxModel, Integer> heightColumn;
    @FXML
    private TableColumn<BoxModel, Integer> widthColumn;
    @FXML
    private TableColumn<BoxModel, Integer> oldPriceColumn;
    @FXML
    private TableColumn<BoxModel, Integer> newPriceColumn;
    private final ObservableList<BoxModel> list = FXCollections.observableArrayList(
            new BoxModel(1, 3, 5, 10, 25),
            new BoxModel(2, 5, 5, 25, 45),
            new BoxModel(3, 3, 10, 30, 75),
            new BoxModel(4, 5, 10, 40, 100)
    );


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("height"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("width"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("newPrice"));
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
        alignCenter();


    }

    private void alignCenter() {

        boxIDColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });

        heightColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });

        widthColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });

        oldPriceColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });
        newPriceColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });
    }


}
