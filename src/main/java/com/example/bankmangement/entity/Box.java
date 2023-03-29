package com.example.bankmangement.entity;

public class Box {

    private Integer id;
    private Integer height;
    private Integer width;
    private Integer oldPrice;
    private Integer newPrice;

    public Box(Integer id, Integer height, Integer width, Integer oldPrice, Integer newPrice) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                '}';
    }
}
