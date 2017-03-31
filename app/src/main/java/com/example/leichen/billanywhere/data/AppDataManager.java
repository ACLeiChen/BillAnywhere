package com.example.leichen.billanywhere.data;

import android.content.Context;

import com.example.leichen.billanywhere.data.db.DbHelper;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.data.model.Item;
import com.example.leichen.billanywhere.data.network.ApiHelper;
import com.example.leichen.billanywhere.data.prefs.PreferencesHelper;
import com.example.leichen.billanywhere.di.ApplicationContext;
import com.example.leichen.billanywhere.utils.AppConstants;
import com.example.leichen.billanywhere.utils.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Lei Chen on 2017/3/13.
 */

public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Observable<Boolean> seedDatabaseBills() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return null;
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
}
