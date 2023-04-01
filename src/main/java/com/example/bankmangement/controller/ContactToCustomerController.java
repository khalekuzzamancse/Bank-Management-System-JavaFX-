package com.example.bankmangement.controller;

import com.example.bankmangement.constants.TableName;
import com.example.bankmangement.entity.Customer;
import com.example.bankmangement.entity.ExpireUser;
import com.example.bankmangement.utils.Alert;
import com.example.bankmangement.utils.Fao;
import com.example.bankmangement.utils.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ContactToCustomerController implements Initializable {
    public TextArea sendEmailTabMessageTextArea;
    public Button sendEmailTabSendButton;
    public TextField sendEmailTabSubjectField;
    public TextField sendEmailTabCustomerIDTextField;
    public TextArea expireNoticeTabMessageTextArea;
    public Button expireNoticeTabSendButton;
    public TextField expireNoticeTabSubjectTextField;
    public TableView<ExpireUser> expireCustomerTable;
    public TableColumn<ExpireUser, Integer> expireCustomerTableCustomerID;
    public TableColumn<ExpireUser, String> expireCustomerTableCustomerEmail;
    public TableColumn<ExpireUser, String> expireCustomerTableExpireDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeExpireCustomerTab();
    }

    @FXML
    private void onSendEmailTabSendButtonClick(ActionEvent event) {
        String subject = sendEmailTabSubjectField.getText();
        String message = sendEmailTabMessageTextArea.getText();
        //
        List<Customer> customerList = new ArrayList<>();
        customerList = Fao.read(TableName.CUSTOMER_TABLE);
        Integer customerID = Integer.parseInt(sendEmailTabCustomerIDTextField.getText());
        Customer customer = FileUtils.getObjectByField("userID", customerID, customerList);
        if (customer != null) {
            System.out.println(subject + "\n" + message);
            Alert.showAlert("Customer Name: " + customer.getName() + "\n" + "Email: " + customer.getEmail());
        } else {
            Alert.showAlert("Customer not found");
        }

    }

    @FXML
    private void onExpireUserTabSendButtonClick(ActionEvent event) {
        String subject = expireNoticeTabSubjectTextField.getText();
        String message = expireNoticeTabMessageTextArea.getText();
        System.out.println(subject + "\n" + message);

    }

    private void initializeExpireCustomerTab() {
        expireCustomerTableCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        expireCustomerTableCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        expireCustomerTableExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        List<ExpireUser> users = new ArrayList<>();
        users.add(new ExpireUser(1, "1", "1"));
        expireCustomerTable.getItems().addAll(users);
    }


}
