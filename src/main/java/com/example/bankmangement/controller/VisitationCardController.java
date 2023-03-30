package com.example.bankmangement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private ImageView descriptionTabSignature;
    @FXML
    private ImageView descriptionTabTodaySignature;
    @FXML
    private ImageView descriptionTabAttendantSignature;
    @FXML
    private Button descriptionTabGrantButton;
    @FXML
    private TextArea descriptionTabTextArea;


    //Card tab
    @FXML
    private Text cardTabBoxNoText;
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
    private ImageView cardTabAttendantSignature;
    @FXML
    private Button cardTabDoneButton;
    @FXML
    private CheckBox cardTabAsDeputyCheckBox;

    //tab pan
    @FXML
    private TabPane tabPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onValidateButtonClick(ActionEvent event) {
        cardTabCustomerIDText.setText(customerIDTextField.getText());
        cardTabBoxNoText.setText(boxNoTextField.getText());
        cardTabAsDeputyCheckBox.setSelected(formAsDeputyCheckBox.isSelected());
        cardTabVisitDateText.setText(getTodayDate());
        cardTabVisitTimeText.setText(getCurrentTime());
        moveToNextTab();
    }

    @FXML
    private void onGrantButtonClick(ActionEvent event) {
        cardTabDescriptionText.setText(descriptionTabTextArea.getText());
        moveToNextTab();

    }

    private void moveToNextTab() {
        int nextTabIndex = tabPane.getSelectionModel().getSelectedIndex() + 1;
        if (nextTabIndex < tabPane.getTabs().size()) {
            tabPane.getSelectionModel().select(nextTabIndex);
        }
    }

    private String getTodayDate() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String current = formatter.format(date);
        LocalDate expire = LocalDate.parse(current);
        return String.valueOf(expire);

    }

    private String getCurrentTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }


}
