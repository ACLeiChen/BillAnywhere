package com.example.leichen.billanywhere.data.db;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.data.model.DaoMaster;
import com.example.leichen.billanywhere.data.model.DaoSession;
import com.example.leichen.billanywhere.data.model.Item;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Lei Chen on 2017/3/28.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Completable saveBill(Bill bill) {
        return null;
    }

    @Override
    public Completable saveBillList(List<Bill> bills) {
        return null;
    }

    @Override
    public Completable saveItem(Item item) {
        return null;
    }

    @Override
    public Completable saveItemList(List<Item> items) {
        return null;
    }

    @Override
    public Observable<Boolean> isBillEmpty() {
        return null;
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return null;
    }

    @Override
    public Observable<List<Bill>> getAllBills() {
        return null;
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return null;
    }
}
