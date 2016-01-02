package com.nfcpay.domain;

/**
 * 商家
 * Created by FengYang on 2015-12-31.
 */
public class Business {
    private String name;
    private String discription;
    private String picUrl;
    private float price;

    public Business() {
    }

    public Business(String name, String discription, String picUrl, float price) {
        this.name = name;
        this.discription = discription;
        this.picUrl = picUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
