package com.example.bankmangement;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class ImageData implements Serializable {
    private transient Image image;
    private byte[] imageData;

    public ImageData(Image image) {
        this.image = image;
        this.imageData = imageToByteArray(image);
    }

    public Image getImage() {
        if (image == null) {
            image = byteArrayToImage(imageData);
        }
        return image;
    }

    private byte[] imageToByteArray(Image image) {
        byte[] imageData = null;
        try {
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", byteOutStream);
            byteOutStream.flush();
            imageData = byteOutStream.toByteArray();
            byteOutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageData;
    }

    private Image byteArrayToImage(byte[] imageData) {
        Image image = null;
        try {
            ByteArrayInputStream byteInStream = new ByteArrayInputStream(imageData);
            image = new Image(byteInStream);
            byteInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
