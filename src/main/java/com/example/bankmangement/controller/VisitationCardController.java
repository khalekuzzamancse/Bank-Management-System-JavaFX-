package com.example.bankmangement.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class VisitationCardController implements Initializable {

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
    private Image signature;
    private Image attendantSignature;

    //tab pan
    @FXML
    private TabPane tabPane;
    private Stage myStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");


        // Get the Scene object from the TabPane


        // Set up a listener for the scene property of the root pane
        tabPane.sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                if (newValue != null) {
                    Scene scene=newValue;


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
        if (signature != null)
            descriptionTabTodaySignature.setImage(signature);
        moveToNextTab();
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

    private void centerContain(Scene scene) {


    }


}
