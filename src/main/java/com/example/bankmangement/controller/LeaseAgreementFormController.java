package com.example.bankmangement.controller;

import com.example.bankmangement.constants.TableName;
import com.example.bankmangement.entity.BoxModel;
import com.example.bankmangement.entity.Customer;
import com.example.bankmangement.entity.HistoryCard;
import com.example.bankmangement.entity.Lease;
import com.example.bankmangement.utils.*;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class LeaseAgreementFormController implements Initializable {
    public ImageView agreementFormCustomerSingnatureImageView;
    public ImageView deputyFormDeputySingnatureImageView;
    public ImageView agreementDocumentDeputySingnatureImageView;
    public ImageView agreementDocumentCustomerSingnatureImageView;
    public ImageView attendeSignatureImageView;
    public GridPane tabLeaseeAgreement;

    @FXML
    private Button agreementTabconfirmButton;
    //For table view
    @FXML
    private AnchorPane tableContainer;

    @FXML
    private TableView<BoxModel> table;
    @FXML
    private TableColumn<BoxModel, Integer> boxIDColumn;
    @FXML
    private TableColumn<BoxModel, Integer> heightColumn;
    @FXML
    private TableColumn<BoxModel, Integer> widthColumn;
    @FXML
    private TableColumn<BoxModel, Integer> oldPriceColumn;
    @FXML
    private TableColumn<BoxModel, Integer> newPriceColumn;
//    List<BoxModel>  boxes= FXCollections.observableArrayList(
//            new BoxModel(1, 3, 5, 10, 25),
//            new BoxModel(2, 5, 5, 25, 45),
//            new BoxModel(3, 3, 10, 30, 75),
//            new BoxModel(4, 5, 10, 40, 100)
//    );


    //
    @FXML
    private Button nextButton;
    @FXML
    private AnchorPane container;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField lesseeIDTextField;
    @FXML
    private TextField boxNumberTextField;
    @FXML
    private TextField durationTextField;
    @FXML
    private Text agrementText;
    @FXML
    private Button nextButton1;

    //deputy form
    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button nextButton2;

    private Customer customer;
    private BoxModel box;
    private Integer generatedBoxNo;
    private Image customerSignature;
    private Image deputySignature;
    private Image attendeeSignature;
    //

    //

    String expireDate;

    @FXML
    private void onGenerate() {


        String lesseeName = customer.getName();
        String duration = durationTextField.getText();
        String rentDate = DateTimeUtils.getCurrentDate();
        expireDate = DateTimeUtils.geDateFromToday(Integer.parseInt(duration));
        String deputyName = nameField.getText();
        String amount = box.getNewPrice().toString();
        //
        generatedBoxNo = generateRandom();
        String boxNo = String.valueOf(generatedBoxNo);

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

        //moving the next tab
        goNextTab();


    }

    private int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(100);
    }


    private void goNextTab() {
        int nextTabIndex = tabPane.getSelectionModel().getSelectedIndex() + 1;
        if (nextTabIndex < tabPane.getTabs().size()) {
            tabPane.getSelectionModel().select(nextTabIndex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("height"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("width"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<BoxModel, Integer>("newPrice"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems((ObservableList<BoxModel>) DemoData.getBoxList());

        table.setLayoutX((tableContainer.getWidth() - tableContainer.getWidth()) / 2);
        // center the label vertically
        table.setLayoutY((tableContainer.getHeight() - tableContainer.getHeight()) / 2);
        tableContainer.widthProperty().addListener((obs, oldVal, newVal) -> {
            // center the label horizontally
            table.setLayoutX((newVal.doubleValue() - table.getWidth()) / 2);
        });
        tableContainer.heightProperty().addListener((obs, oldVal, newVal) -> {
            // center the label vertically
            table.setLayoutY((newVal.doubleValue() - table.getHeight()) / 2);
        });
        alignCenter();

    }

    @FXML
    private void onAgreementFormNextButtonClick(ActionEvent event) {

        customer = new Customer();
        String lesseeID = lesseeIDTextField.getText();
        List<Customer> customerList = new ArrayList<>();
        customerList = Fao.read(TableName.CUSTOMER_TABLE);
        Integer customerID = Integer.parseInt(lesseeID);
        //960370
        customer = FileUtils.getObjectByField("userID", customerID, customerList);
        if (customer != null) {
            AlertUtil.showAlert("Customer Name: " + customer.getName());
            goNextTab();
        } else {
            //to avoid null pointer exeption,if the customer is null then
            //initailze with empty object
            customer = new Customer();
            AlertUtil.showAlert("Customer not found");
        }
        ///
        Integer boxID = Integer.parseInt(boxNumberTextField.getText());
        box = FileUtils.getObjectByField("id", boxID, DemoData.getBoxList());
        if (box != null) {
            AlertUtil.showAlert("New price: " + box.getNewPrice() + "$" + "\n" + "Old price : " + box.getOldPrice());
        } else {
            AlertUtil.showAlert("Box not found");
        }


    }

    @FXML
    void onRentButtonClick(ActionEvent event) {
        goNextTab();
    }

    @FXML
    private void onNextButton2() {
        onGenerate();
        int nextTabIndex = tabPane.getSelectionModel().getSelectedIndex() + 1;
        if (nextTabIndex < tabPane.getTabs().size()) {
            tabPane.getSelectionModel().select(nextTabIndex);
        }
    }

    private void alignCenter() {

        boxIDColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });

        heightColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });

        widthColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });

        oldPriceColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });
        newPriceColumn.setCellFactory(column -> new TableCell<BoxModel, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });
    }


    @FXML
    private void onCustomerSignetureImageSelected(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);
        Scene currentScene = tabPane.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            customerSignature = image;
            agreementFormCustomerSingnatureImageView.setImage(image);
            agreementDocumentCustomerSingnatureImageView.setImage(image);
            System.out.println(selectedFile.toURI());
        }
    }

    @FXML
    private void onDeputySignetureImageSelected(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);
        Scene currentScene = tabPane.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            deputySignature = image;
            deputyFormDeputySingnatureImageView.setImage(image);
            agreementDocumentDeputySingnatureImageView.setImage(image);
        }
    }

    @FXML
    private void onAttendeeSignetureImageSelected(MouseEvent mouseEvent) {
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);
        Scene currentScene = tabPane.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            attendeeSignature = image;
            attendeSignatureImageView.setImage(image);
        }
    }

    @FXML
    private void onConfirmButtonClick(ActionEvent event) {
      insertToDatabase();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Save as pdf?");
        //   alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            //hiding the conifirm button so that it not shown in the pdf
            agreementTabconfirmButton.setVisible(false);
            new PdfUtil().generatePDF(tabLeaseeAgreement);
            //
            agreementTabconfirmButton.setVisible(true);
        }

    }

    private void insertToDatabase() {
        if (deputySignature != null) {
            Lease lease = new Lease(
                    customer.getUserID(), box.getNewPrice(), customerSignature,
                    generatedBoxNo,
                    DateTimeUtils.getCurrentDate(),
                    expireDate,
                    nameField.getText(),
                    addressField.getText(),
                    phoneField.getText(),
                    deputySignature
            );
            System.out.println(lease);
            Fao.write(TableName.LEASE_TABLE, lease);
            addHistoryCard();
        } else {
            Lease lease = new Lease(
                    customer.getUserID(), box.getNewPrice(), customerSignature,
                    generatedBoxNo,
                    DateTimeUtils.getCurrentDate(),
                    expireDate
            );
            System.out.println(lease);
            Fao.write(TableName.LEASE_TABLE, lease);
            addHistoryCard();
        }
    }

    private void addHistoryCard() {
        HistoryCard card = new HistoryCard
                (generatedBoxNo, customer.getUserID(),
                        DateTimeUtils.getCurrentDate(), attendeeSignature
                );
        Fao.write(TableName.HISTORY_CARD_TABLE, card);

    }


}
