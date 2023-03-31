package com.example.bankmangement;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerController implements Initializable {

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> nameCol;

    @FXML
    private TableColumn<Customer, String> emailCol;

    @FXML
    private TableColumn<Customer, String> phoneCol;

    @FXML
    private TableColumn<Customer, String> firmCol;

    @FXML
    private TableColumn<Customer, String> addressCol;

    @FXML
    private TableColumn<Customer, String> eyeColorCol;

    @FXML
    private TableColumn<Customer, String> hairColorCol;

    @FXML
    private TableColumn<Customer, String> heightCol;

    @FXML
    private TableColumn<Customer, String> weightCol;

    @FXML
    private TableColumn<Customer, Double> balanceCol;

    @FXML
    private TableColumn<Customer, Integer> userIdCol;

    private List<Customer> customerList;

    public CustomerController() {
        // initialize the customer list with dummy data
        customerList = new ArrayList<>();
        customerList.add(new Customer("John Doe", "johndoe@example.com", "555-1234", "ACME Corp", "123 Main St", "blue", "brown", "6'2\"", "180 lbs", 1000.0));
        customerList.add(new Customer("Jane Smith", "janesmith@example.com", "555-5678", "Globex Corp", "456 High St", "green", "blonde", "5'6\"", "130 lbs", 2000.0));
        customerList.add(new Customer("Bob Johnson", "bobjohnson@example.com", "555-2468", "Initech", "789 Broad St", "brown", "gray", "5'10\"", "160 lbs", 500.0));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // configure the table columns to display data from the Customer class

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));;
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        firmCol.setCellValueFactory(new PropertyValueFactory<>("firm"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        eyeColorCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        hairColorCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        balanceCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        // populate the table with the customer list data
        customerTable.getItems().addAll(customerList);
    }
}
