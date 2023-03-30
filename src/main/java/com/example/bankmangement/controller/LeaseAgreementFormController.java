package com.example.bankmangement.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LeaseAgreementFormController {

    @FXML
    private TextField lesseeIDTextField;
    @FXML
    private TextField boxNumberTextField;
    @FXML
    private TextField durationTextField;
    @FXML
    private TextField deputyIDTextField;
    @FXML
    private TextField depositAmountTextField;
    @FXML
    private Text agrementText;
    @FXML
    private Button generateButton;

    @FXML
    private void onGenerate() {
        String lessee = lesseeIDTextField.getText();
        String boxNo = boxNumberTextField.getText();
        String duration = durationTextField.getText();
        String deputyID = deputyIDTextField.getText();

        String lesseeName = "Md Jakaria";
        String rentDate = "12-12-12";
        String expireDate = "12-12-13";
        String amount = "500";
        String deputyName = "Khalek";


        String s = "Lease Agreement between " + lesseeName + "(Lessee) and Miami Bank (Lessor)" +
                " for Safe Deposit Box #" + boxNo + " for the term of " + duration + " month," +
                " commencing on " + rentDate + " and ending on " + expireDate + "" +
                " Lessee agrees to pay Lessor $" + amount + " and to comply with all rules and regulations " +
                "of Lessor regarding the use of the Box. If additional persons are to have access" +
                " to the safe deposit box, a deputy must be appointed." +
                "The name of the deputy for this Box is " + deputyName +
                " and their signature is recorded below." +
                "Lessee acknowledges that the deputy has access to the Box." +
                "Lessee acknowledges that Lessor shall not be liable for any" +
                " loss or damage to the property stored in the Box." +
                "Lessee agrees to indemnify and hold Lessor harmless from any and all claims," +
                " damages, or expenses arising out of or in connection with Lessee's use of the Box." +
                "This Agreement shall be governed by and construed in accordance with the laws of " +
                "the state of Florida.";
        agrementText.setText(s);


    }

}
