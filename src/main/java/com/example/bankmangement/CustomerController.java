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
        customerList=Fao.read(TableName.CUSTOMER_TABLE);

        Customer customer = FileUtils.getObjectByField("userID", 960370, customerList);
        if (customer != null)
            System.out.printf(customer.toString());
        else
            System.out.println("Not Found");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // configure the table columns to display data from the Customer class

        nameCol.setCellValueFactory(new PropertyValueFactory<>("userID"));;
        emailCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        firmCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        eyeColorCol.setCellValueFactory(new PropertyValueFactory<>("eyeColor"));
        hairColorCol.setCellValueFactory(new PropertyValueFactory<>("hairColor"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        balanceCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("firm"));
        // populate the table with the customer list data
        customerTable.getItems().addAll(customerList);
    }
}
