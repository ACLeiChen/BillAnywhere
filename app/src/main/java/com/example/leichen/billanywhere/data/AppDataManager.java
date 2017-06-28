package com.example.leichen.billanywhere.data;

import android.content.Context;

import com.example.leichen.billanywhere.data.db.DbHelper;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.data.model.Item;
import com.example.leichen.billanywhere.data.network.ApiHelper;
import com.example.leichen.billanywhere.data.prefs.PreferencesHelper;
import com.example.leichen.billanywhere.di.ApplicationContext;
import com.example.leichen.billanywhere.utils.AppConstants;
import com.example.leichen.billanywhere.utils.BillDeserializer;
import com.example.leichen.billanywhere.utils.CommonUtils;
import com.example.leichen.billanywhere.utils.MvpLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Lei Chen on 2017/3/13.
 */

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;
    }

    @Override
    public Completable seedDatabaseBills() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        builder.registerTypeAdapter(Bill.class, new BillDeserializer());
        final Gson gson = builder.create();

        Type type = new TypeToken<List<Bill>>(){}.getType();
        List<Bill> bills = new ArrayList<>();
        try {
            bills = gson.fromJson(CommonUtils.loadJSONFromAsset(mContext, AppConstants.SEED_DATABASE_BILLS), type);
        } catch (IOException e) {
            e.printStackTrace();
            MvpLogger.e(e, "seedDatabaseBills failed.");
        }
        return saveBillList(bills);
    }

    @Override
    public Completable saveBill(Bill bill) {
        return mDbHelper.saveBill(bill);
    }

    @Override
    public Completable saveBillList(List<Bill> bills) {
        return mDbHelper.saveBillList(bills);
    }

    @Override
    public Completable saveItem(Item item) {
        return mDbHelper.saveItem(item);
    }

    @Override
    public Completable saveItemList(List<Item> items) {
        return mDbHelper.saveItemList(items);
    }

    @Override
    public Observable<Boolean> isBillEmpty() {
        return mDbHelper.isBillEmpty();
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return mDbHelper.isItemEmpty();
    }

    @Override
    public Observable<List<Bill>> getAllBills() {
        return mDbHelper.getAllBills();
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return mDbHelper.getAllItems();
    }

    @Override
    public Observable<Bill> getBill(Long id) {
        return mDbHelper.getBill(id);
    }
}
