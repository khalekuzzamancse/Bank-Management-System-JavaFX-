package com.example.bankmangement.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PdfUtil {
    public void generatePDF(Node node) {
        // create a new PDF document
        PDDocument document = new PDDocument();

        // create a new page in the document
        PDPage page = new PDPage();
        document.addPage(page);

        // create a new content stream for the page
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {


            // create a new JavaFX image from the AnchorPane and render it to the PDF page
            WritableImage image = node.snapshot(new SnapshotParameters(), null);
            PDImageXObject xImage = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(image, null));
            contentStream.drawImage(xImage, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());

            // close the content stream
            contentStream.close();

            // show a file chooser dialog to save the PDF file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.setInitialFileName("document.pdf");
            File outputFile = fileChooser.showSaveDialog(new Stage());

            if (outputFile != null) {
                // save the PDF document to the selected file
                document.save(outputFile);
                document.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
