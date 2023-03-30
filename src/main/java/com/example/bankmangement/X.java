package com.example.bankmangement;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;

public class X implements Serializable {
    private Integer id;
    private ImageData imageData;

    public X(Integer id, ImageData imageData) {
        this.id = id;
        this.imageData = imageData;
    }

    public Integer getId() {
        return id;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImageData(ImageData imageData) {
        this.imageData = imageData;
    }
}

