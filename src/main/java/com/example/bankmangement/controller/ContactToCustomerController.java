package com.example.bankmangement.controller;

import com.example.bankmangement.constants.TableName;
import com.example.bankmangement.entity.Customer;
import com.example.bankmangement.utils.Alert;
import com.example.bankmangement.utils.Fao;
import com.example.bankmangement.utils.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ContactToCustomerController implements Initializable {
    public TextArea sendEmailTabMessageTextArea;
    public Button sendEmailTabSendButton;
    public TextField sendEmailTabSubjectField;
    public TextField sendEmailTabCustomerIDTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            System.out.println(subject+"\n"+message);
            Alert.showAlert("Customer Name: " + customer.getName() + "\n" + "Email: " + customer.getEmail());
        } else {
            Alert.showAlert("Customer not found");
        }

    }


}
