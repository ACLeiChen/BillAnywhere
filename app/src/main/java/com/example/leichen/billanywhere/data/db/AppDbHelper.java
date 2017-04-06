package com.example.leichen.billanywhere.data.db;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.data.model.DaoMaster;
import com.example.leichen.billanywhere.data.model.DaoSession;
import com.example.leichen.billanywhere.data.model.Item;

import java.util.List;
import java.util.concurrent.Callable;

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
        return Completable.fromAction(() -> mDaoSession.getBillDao().insert(bill));
    }

    @Override
    public Completable saveBillList(List<Bill> bills) {
        return Completable.fromAction(() -> mDaoSession.getBillDao().insertInTx(bills));
    }

    @Override
    public Completable saveItem(Item item) {
        return Completable.fromAction(() -> mDaoSession.getItemDao().insert(item));
    }

    @Override
    public Completable saveItemList(List<Item> items) {
        return Completable.fromAction(() -> mDaoSession.getItemDao().insertInTx(items));
    }

    @Override
    public Observable<Boolean> isBillEmpty() {
        return Observable.fromCallable(() -> !(mDaoSession.getBillDao().count() > 0));
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return Observable.fromCallable(() -> !(mDaoSession.getItemDao().count() > 0));
    }

    @Override
    public Observable<List<Bill>> getAllBills() {
        return Observable.fromCallable(() -> mDaoSession.getBillDao().loadAll());
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return Observable.fromCallable(() -> mDaoSession.getItemDao().loadAll());
    }
}
