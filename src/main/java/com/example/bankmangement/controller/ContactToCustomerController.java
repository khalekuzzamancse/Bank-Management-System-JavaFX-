package com.example.bankmangement.controller;

import com.example.bankmangement.ExpireUserUtil;
import com.example.bankmangement.constants.TableName;
import com.example.bankmangement.entity.Customer;
import com.example.bankmangement.entity.ExpireUser;
import com.example.bankmangement.utils.AlertUtil;
import com.example.bankmangement.utils.Fao;
import com.example.bankmangement.utils.FileUtils;
import com.example.bankmangement.utils.SendMailUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.Optional;
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
    public TableColumn<ExpireUser, String> expireCustomerTableName;
    public TableColumn<ExpireUser, Integer> expireCustomerTableBoxNo;
    //
    private List<ExpireUser> expireUsers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//
        initializeExpireCustomerTab();
    }

    @FXML
    private void onSendEmailTabSendButtonClick() {


        String subject = sendEmailTabSubjectField.getText();
        String message = sendEmailTabMessageTextArea.getText();
        //
        List<Customer> customerList;
        customerList = Fao.read(TableName.CUSTOMER_TABLE);
        Integer customerID = Integer.parseInt(sendEmailTabCustomerIDTextField.getText());
        Customer customer = FileUtils.getObjectByField("userID", customerID, customerList);
        if (customer != null) {
            System.out.println(subject + "\n" + message);
            AlertUtil.showAlert("Customer Name: " + customer.getName() + "\n" + "Email: " + customer.getEmail());
        } else {
            AlertUtil.showAlert("Customer not found");
        }

    }

    @FXML
    private void onExpireUserTabSendButtonClick() {
        String subject = expireNoticeTabSubjectTextField.getText();
        String msg = expireNoticeTabMessageTextArea.getText();

        for (ExpireUser user : expireUsers) {
            String message = generateMessage(user) + "\n" + msg;
            String receiver = user.getEmail();
            //  String receiver="khalekuzzaman91@gmail.com";
            System.out.println(subject + "\n" + message);
            new SendMailUtil().send(receiver, subject, msg);

        }
    }

    private void initializeExpireCustomerTab() {
        expireCustomerTableCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        expireCustomerTableCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        expireCustomerTableExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        expireCustomerTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        expireCustomerTableBoxNo.setCellValueFactory(new PropertyValueFactory<>("boxNumber"));
        //  System.out.println(users);
        expireUsers = ExpireUserUtil.getExpireUsers();
        expireCustomerTable.getItems().addAll(expireUsers);

    }

    private String generateMessage(ExpireUser user) {
        return ("Dear, " + user.getName() + "." +
                "\n" +
                "your box(number=" + user.getBoxNumber() + ") " +
                "will be expired on " + user.getExpireDate() + "."
        );
    }

}
