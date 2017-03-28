package com.example.leichen.billanywhere.data.db;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.data.model.Item;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Lei Chen on 2017/3/13.
 */

public interface DbHelper {

    Completable saveBill(Bill bill);
    Completable saveBillList(List<Bill> bills);
    Completable saveItem(Item item);
    Completable saveItemList(List<Item> items);

    Observable<Boolean> isBillEmpty();
    Observable<Boolean> isItemEmpty();

    Observable<List<Bill>> getAllBills();
    Observable<List<Item>> getAllItems();
}
