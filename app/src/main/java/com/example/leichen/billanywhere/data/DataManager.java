package com.example.leichen.billanywhere.data;

import com.example.leichen.billanywhere.data.db.DbHelper;

import com.example.leichen.billanywhere.data.network.ApiHelper;
import com.example.leichen.billanywhere.data.prefs.PreferencesHelper;

import io.reactivex.Observable;
/**
 * Created by Lei Chen on 2017/3/13.
 */

public interface DataManager extends DbHelper, ApiHelper, PreferencesHelper {
    Observable<Boolean> seedDatabaseBills();
}
