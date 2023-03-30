package com.example.bankmangement.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class LeaseAgreementFormController {
    @FXML
    private AnchorPane container;
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
