package com.khobre.karayek.ui.model;

import com.google.gson.annotations.SerializedName;

public class Price {
@SerializedName("price")
    String price;
    int id;

    public Price(String price) {
        this.price = price;
    }


    public Price() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
