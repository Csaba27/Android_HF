package com.example.mycurrencies;

class Currency {
    private String name;
    private String code;
    private Double rate;
    private Integer image;

    public Currency(String code, String name, Integer image) {
        this.code = code;
        this.name = name;
        this.image = image;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
