package com.example.mycurrencies;

import java.io.Serializable;

public class Currency implements Serializable {
    private String name;
    private String code;
    private Double sellPrice;
    private Double buyPrice;
    private Integer image;

    public Currency(String code, String name, Integer image, Double buyPrice, Double sellPrice) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
