package com.example.karayek.ui.sahmList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SahamListModel {

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("BourseSymbol")
    @Expose
    String group;
    @SerializedName("FullTitle")
    @Expose
    String title;
    @SerializedName("count")
    @Expose
    String count;
    @SerializedName("LastPrice")
    @Expose
    String livePrice;
    /*@SerializedName("MaxPrice")
    @Expose*/
    String stocksValue;
    /*@SerializedName("OpeningPrice")
    @Expose*/
    String sum_price;


    public SahamListModel(String group, String title, String count, String livePrice, String stocksValue,String sum_price) {
        this.group = group;
        this.title = title;
        this.count = count;
        this.livePrice = livePrice;
        this.stocksValue = stocksValue;
        this.sum_price = sum_price;
    }


    public SahamListModel() {
    }


    public String getSum_price() {
        return sum_price;
    }

    public void setSum_price(String sum_price) {
        this.sum_price = sum_price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLivePrice() {
        return livePrice;
    }

    public void setLivePrice(String livePrice) {
        this.livePrice = livePrice;
    }

    public String getStocksValue() {
        return stocksValue;
    }

    public void setStocksValue(String stocksValue) {
        this.stocksValue = stocksValue;
    }
}
