package com.example.bankmangement.controller;

import com.example.bankmangement.entity.BoxModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class LeaseAgreementFormController implements Initializable {
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
    private final ObservableList<BoxModel> list = FXCollections.observableArrayList(
            new BoxModel(1, 3, 5, 10, 25),
            new BoxModel(2, 5, 5, 25, 45),
            new BoxModel(3, 3, 10, 30, 75),
            new BoxModel(4, 5, 10, 40, 100)
    );


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
    private TextField deputyIDTextField;
    @FXML
    private TextField depositAmountTextField;
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
//


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

        //moving the next tab
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
        table.setItems(list);

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
    void handleNextButtonAction(ActionEvent event) {
        int nextTabIndex = tabPane.getSelectionModel().getSelectedIndex() + 1;
        if (nextTabIndex < tabPane.getTabs().size()) {
            tabPane.getSelectionModel().select(nextTabIndex);
        }
    }

    @FXML
    private void onNextButton2() {
        String name = nameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);

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

//    private void generatePDF() {
//        // create a new PDF document
//        PDDocument document = new PDDocument();
//
//        // create a new page in the document
//        PDPage page = new PDPage();
//        document.addPage(page);
//
//        // create a new content stream for the page
//        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//
//            // create a new JavaFX scene for the AnchorPane
//            Scene scene = new Scene(container);
//
//            // create a new JavaFX image from the AnchorPane and render it to the PDF page
//            WritableImage image = container.snapshot(new SnapshotParameters(), null);
//            PDImageXObject xImage = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(image, null));
//            contentStream.drawImage(xImage, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
//
//            // close the content stream
//            contentStream.close();
//
//            // show a file chooser dialog to save the PDF file
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Save PDF");
//            fileChooser.setInitialFileName("document.pdf");
//            File outputFile = fileChooser.showSaveDialog(new Stage());
//
//            if (outputFile != null) {
//                // save the PDF document to the selected file
//                document.save(outputFile);
//                document.close();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
