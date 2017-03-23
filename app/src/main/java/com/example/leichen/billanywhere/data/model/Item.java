
package com.example.leichen.billanywhere.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("kind")
    @Expose
    private String kind;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param amount
     * @param itemName
     * @param rate
     * @param quantity
     * @param kind
     */
    public Item(String itemName, Integer quantity, Integer rate, Integer amount, String kind) {
        super();
        this.itemName = itemName;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.kind = kind;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

}
