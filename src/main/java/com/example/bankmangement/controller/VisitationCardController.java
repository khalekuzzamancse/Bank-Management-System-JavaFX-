package com.example.bankmangement.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VisitationCardController implements Initializable {


    //Form

    @FXML
    private TextField customerIDTextField;
    @FXML
    private TextField boxNoTextField;
    @FXML
    private ImageView formSignatureImageView;
    @FXML
    private CheckBox formAsDeputyCheckBox;

    //description tab
    @FXML
    private Text descriptionTabBoxNoText;
    @FXML
    private Text descriptionTabProviedBoxNoText;
    @FXML
    private ImageView descriptionTabSignature;
    @FXML
    private ImageView descriptionTabTodaySignature;
    @FXML
    private Button descriptionTabGrantButton;
    @FXML
    private TextArea descriptionTabTextArea;


    //Card tab
    @FXML
    private Text cardTabDescriptionText;
    @FXML
    private Text cardTabCustomerIDText;
    @FXML
    private Text cardTabVisitDateText;
    @FXML
    private Text cardTabVisitTimeText;
    @FXML
    private ImageView cardTabSignature;
    @FXML
    private ImageView cardTabAtteandeSignature;
    @FXML
    private Button cardTabDoneButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
