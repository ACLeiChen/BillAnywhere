
package com.example.leichen.billanywhere.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bill {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("shop_name")
    @Expose
    private String shopName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Bill() {
    }

    /**
     * 
     * @param items
     * @param shopName
     * @param date
     */
    public Bill(List<Item> items, String date, String shopName) {
        super();
        this.items = items;
        this.date = date;
        this.shopName = shopName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

}
