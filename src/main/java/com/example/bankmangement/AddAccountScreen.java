package com.example.bankmangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddAccountScreen {


    Scene scene;
    private GridPane container;

    private TextField nameTextField;
    private TextField emailTextField;
    private TextField phoneNumberTextField;
    private TextField hairColorTextField;
    private TextField eyeColorTextField;
    private TextField heightTextField;
    private TextField weightTextField;
    private TextField balanceTextField;
    private TextField firmTextField;
    private TextField nomineeNameTextField;
    private TextField nomineeRelationshipTextField;
    private Button addButton;

    private FileChooser fileChooser;
    private ImageView customerImageView;
    private ImageView nomineeImageView;
    private ImageView customerSignatureImageView;
    private ImageView nomineeSignatureImageView;
    private Stage stage;

    public AddAccountScreen(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/add_account_layout.fxml"));
        this.stage = stage;
        loader.setController(this);
        Parent root;
        root = loader.load();

        scene = new Scene(root);
        initialize();

        //centering the content
        container = (GridPane) scene.lookup("#container");

        container.setLayoutX((scene.getWidth() - container.getWidth()) / 2);
        // center the label vertically
        container.setLayoutY((scene.getHeight() - container.getHeight()) / 2);
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            // center the label horizontally
            container.setLayoutX((newVal.doubleValue() - container.getWidth()) / 2);
        });
        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            // center the label vertically
            container.setLayoutY((newVal.doubleValue() - container.getHeight()) / 2);
        });


    }

    private void onAddClick(ActionEvent event) {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String firm = firmTextField.getText();
        String eyeColor = eyeColorTextField.getText();
        String hairColor = hairColorTextField.getText();
        String height = heightTextField.getText();
        String weight = weightTextField.getText();
        String balance = balanceTextField.getText();
        String nomineeName = nomineeNameTextField.getText();
        System.out.println(
                "name" + ":" + name + "\n" +
                        "email" + ":" + email + "\n" +
                        "phone" + ":" + phoneNumber + "\n" +
                        "firm" + ":" + firm + "\n" +
                        "eyeColor" + ":" + eyeColor + "\n" +
                        "hairColor" + ":" + hairColor + "\n" +
                        "height" + ":" + height + "\n" +
                        "weight" + ":" + weight + "\n" +
                        "balance" + ":" + balance + "\n" +
                        "nomineeName" + ":" + nomineeName + "\n"
        );

    }

    private void initialize() {
        addButton = (Button) scene.lookup("#addButton");
        addButton.setOnAction(this::onAddClick);
        nameTextField = (TextField) scene.lookup("#nameTextField");
        emailTextField = (TextField) scene.lookup("#emailTextField");
        phoneNumberTextField = (TextField) scene.lookup("#phoneTextField");
        hairColorTextField = (TextField) scene.lookup("#hairColorTextField");
        eyeColorTextField = (TextField) scene.lookup("#eyeColorTextField");
        balanceTextField = (TextField) scene.lookup("#balanceTextField");
        heightTextField = (TextField) scene.lookup("#heightTextField");
        weightTextField = (TextField) scene.lookup("#weightTextField");
        firmTextField = (TextField) scene.lookup("#firmTextField");
        nomineeNameTextField = (TextField) scene.lookup("#nomineeNameTextField");

        //
        nomineeImageView = (ImageView) scene.lookup("#nomineeImageView");
        nomineeImageView.setOnMouseClicked(this::onNomineeImageSelected);
        customerImageView = (ImageView) scene.lookup("#customerImageView");
        customerImageView.setOnMouseClicked(this::onCustomerImageSelected);
        customerSignatureImageView = (ImageView) scene.lookup("#customerSignatureImageView");
        nomineeSignatureImageView = (ImageView) scene.lookup("#nomineeSignatureImageView");
        customerSignatureImageView.setOnMouseClicked(this::onCustomerSignetureImageSelected);
        nomineeSignatureImageView.setOnMouseClicked(this::onNomineeSignetureImageSelected);


        //
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
    }

    private void onNomineeSignetureImageSelected(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            nomineeSignatureImageView.setImage(image);
        }
    }

    private void onCustomerSignetureImageSelected(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            customerSignatureImageView.setImage(image);
        }

    }


    //    Stage stage = (Stage) chooseButton.getScene().getWindow();
    private void onCustomerImageSelected(MouseEvent event) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            customerImageView.setImage(image);
        }
    }

    private void onNomineeImageSelected(MouseEvent event) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            nomineeImageView.setImage(image);
        }
    }

    public Scene getScene() {
        return scene;
    }
}
