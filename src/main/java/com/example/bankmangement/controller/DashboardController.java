package com.example.bankmangement.controller;

import com.example.bankmangement.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Button addAccountButton;
    public Button leaseButton;
    public Button contactButton;
    public Button visitationButton;
    public Button viewInfoButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //        Windows.getInstance().leaseAgreementWindow().show();
//        Windows.getInstance().infoViewWindow().show();
//        Windows.getInstance().customerContactWindow().show();
//        Windows.getInstance().visitationWindow().show();
//        Windows.getInstance().addAccountWindow().show();
//        Windows.getInstance().loginWindow().show();
    }
    @FXML
    private void onAddAccount(ActionEvent event){

        Windows.getInstance().addAccountWindow().show();
    }
    @FXML
    private void onLease(ActionEvent event){
        Windows.getInstance().leaseAgreementWindow().show();
    }
    @FXML
    private void onContact(ActionEvent event){
        Windows.getInstance().customerContactWindow().show();
    }
    @FXML
    private void onVisitation(ActionEvent event){
        Windows.getInstance().visitationWindow().show();
    }
    @FXML
    private void onViewInfo(ActionEvent event){
        Windows.getInstance().infoViewWindow().show();
    }
}
