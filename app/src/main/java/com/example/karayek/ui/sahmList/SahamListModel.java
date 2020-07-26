package com.example.karayek.ui.sahmList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SahamListModel {

    @SerializedName("CoID")
    @Expose
    int id;

    String group;
	@SerializedName("BourseSymbol")
	@Expose
    String title;
    @SerializedName("TradeQty")
    @Expose
    int count;

	@SerializedName("LastPrice")
	@Expose
    float livePrice;
    @SerializedName("MaxPrice")
    @Expose
    float stocksValue;
    @SerializedName("OpeningPrice")
    @Expose
    float sum_price;


    public SahamListModel(String group, String title, int count, float livePrice, float stocksValue) {
        this.group = group;
        this.title = title;
        this.count = count;
        this.livePrice = livePrice;
        this.stocksValue = stocksValue;
    }
/*

    public SahamListModel() {
    }
*/

    public float getSum_price() {
        return sum_price;
    }

    public void setSum_price(float sum_price) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getLivePrice() {
        return livePrice;
    }

    public void setLivePrice(float livePrice) {
        this.livePrice = livePrice;
    }

    public float getStocksValue() {
        return stocksValue;
    }

    public void setStocksValue(float stocksValue) {
        this.stocksValue = stocksValue;
    }
}
