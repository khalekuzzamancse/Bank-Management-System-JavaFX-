package com.example.bankmangement.controller;

import com.example.bankmangement.utils.*;
import com.example.bankmangement.constants.TableName;
import com.example.bankmangement.entity.Lease;
import com.example.bankmangement.entity.VisitationCard;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VisitationCardController implements Initializable {

    public GridPane cardTabGrid;
    @FXML
    private GridPane fromGrid;
    @FXML
    private Tab form;

    private FileChooser fileChooser;
    //Form

    @FXML
    private TextField customerIDTextField;
    @FXML
    private TextField boxNoTextField;
    @FXML
    private ImageView formSignatureImageView;
    @FXML
    private CheckBox formAsDeputyCheckBox;
    @FXML
    private Button validateButton;


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
    private TextArea cardTabDescriptionText;
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
    private Image signature;
    private Image attendantSignature;

    //tab pan
    @FXML
    private TabPane tabPane;
    private Stage myStage;
    //
    private Lease lease;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");


        // Set up a listener for the scene property of the root pane
        tabPane.sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                if (newValue != null) {
                    Scene scene = newValue;


                }
            }
        });

        //centering the content


    }

    @FXML
    private void onValidateButtonClick(ActionEvent event) {
        cardTabCustomerIDText.setText(customerIDTextField.getText());
        cardTabBoxNoText.setText(boxNoTextField.getText());
        cardTabAsDeputyCheckBox.setSelected(formAsDeputyCheckBox.isSelected());
        cardTabVisitDateText.setText(getTodayDate());
        cardTabVisitTimeText.setText(getCurrentTime());
        descriptionTabTodaySignature.setImage(signature);

        List<Lease> leaseList = new ArrayList<>();
        leaseList = Fao.read(TableName.LEASE_TABLE);
        Integer boxNo = Integer.parseInt(boxNoTextField.getText());
//        //87
        lease = FileUtils.getObjectByField("boxNumber", boxNo, leaseList);
        if (lease != null) {
            if (formAsDeputyCheckBox.isSelected()) {
                descriptionTabSignature.setImage(lease.getDeputySignature());
            } else {
                descriptionTabSignature.setImage(lease.getCustomerSignature());
            }

            moveToNextTab();
        } else {
            AlertUtil.showAlert("Box not found\nCustomerID or Box number is incorrect");
        }

    }

    @FXML
    private void onGrantButtonClick(ActionEvent event) {
        cardTabDescriptionText.setText(descriptionTabTextArea.getText());
        if (signature != null) {
            cardTabSignature.setImage(signature);
        }
        if (attendantSignature != null) {
            cardTabAttendantSignature.setImage(attendantSignature);
        }

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

    @FXML
    private void onCustomerSignetureImageSelected(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        Scene currentScene = formSignatureImageView.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            formSignatureImageView.setImage(image);
            signature = image;
        }


        // currentStage.close();

    }

    @FXML
    private void onDescriptionTabAttendantSignature(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        Scene currentScene = formSignatureImageView.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            descriptionTabAttendantSignature.setImage(image);
            attendantSignature = image;

        }


        // currentStage.close();

    }

    @FXML
    private void onDoneButtonClick(ActionEvent event) {
        VisitationCard card = new VisitationCard
                (Integer.parseInt(cardTabCustomerIDText.getText()), Integer.parseInt(cardTabBoxNoText.getText()),
                        DateTimeUtils.getCurrentDate(), DateTimeUtils.getCurrentTime(),
                        signature, attendantSignature, cardTabAsDeputyCheckBox.isSelected(), cardTabDescriptionText.getText());
        System.out.println(card);
        Fao.write(TableName.VISITATION_CARD_TABLE, card);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Save as pdf?");
        //   alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            //before creating pdf hiding the done button
            cardTabDoneButton.setVisible(false);
            new PdfUtil().generatePDF(cardTabGrid);
            cardTabDoneButton.setVisible(true);
        }

    }

    private void centerContain(Scene scene) {


    }


}
