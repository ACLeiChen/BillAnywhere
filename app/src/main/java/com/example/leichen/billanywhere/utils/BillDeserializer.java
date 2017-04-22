package com.example.leichen.billanywhere.utils;

/**
 * Created by Lei Chen on 2017/4/22.
 */

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.data.model.Item;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class BillDeserializer implements JsonDeserializer<Bill> {

    @Override
    public Bill deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        Type type = new TypeToken<List<Item>>(){}.getType();
        List<Item> items = context.deserialize(jsonObject.get("items"), type);

        final Double total_amount = jsonObject.get("total_amount").getAsDouble();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String shopping_date = jsonObject.get("shopping_date").getAsString();
        Date shoppingDate = null;
        try {
            shoppingDate = format.parse(shopping_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final String shopName = jsonObject.get("shop_name").getAsString();
        final String createdAt = jsonObject.get("created_at").getAsString();
        final String updatedAt = jsonObject.get("updated_at").getAsString();

        final Bill bill = new Bill();
        bill.setItems(items);
        bill.setTotalAmount(total_amount);
        bill.setShoppingDate(shoppingDate);
        bill.setShopName(shopName);
        bill.setCreatedAt(createdAt);
        bill.setUpdatedAt(updatedAt);
        return bill;
    }
}