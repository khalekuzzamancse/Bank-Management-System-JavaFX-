package com.example.bankmangement.controller;

import com.example.bankmangement.*;
import com.example.bankmangement.entity.BoxModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


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
    //


    @FXML
    private void onGenerate() {


        String lesseeName = customer.getName();
        String duration = durationTextField.getText();
        String rentDate = DateTimeUtils.getCurrentDate();
        String expireDate = DateTimeUtils.geDateFromToday(Integer.parseInt(duration));
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
            System.out.printf(customer.toString());
            goNextTab();
        } else {
            //to avoid null pointer exeption,if the customer is null then
            //initailze with empty object
            customer = new Customer();
            System.out.println("Not Found");
        }
        ///
        Integer boxID = Integer.parseInt(boxNumberTextField.getText());
        box = FileUtils.getObjectByField("id", boxID, DemoData.getBoxList());
        if (box != null) {
            System.out.println(box);
        } else {
            System.out.println("Box not found");
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
