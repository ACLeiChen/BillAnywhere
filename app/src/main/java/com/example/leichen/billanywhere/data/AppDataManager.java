package com.example.leichen.billanywhere.data;

import android.content.Context;

import com.example.leichen.billanywhere.data.db.DbHelper;
import com.example.leichen.billanywhere.data.model.Bill;
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
}
