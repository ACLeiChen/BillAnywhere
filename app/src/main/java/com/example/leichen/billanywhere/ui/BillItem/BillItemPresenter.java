package com.example.leichen.billanywhere.ui.BillItem;

import com.example.leichen.billanywhere.data.DataManager;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.base.BasePresenter;
import com.example.leichen.billanywhere.ui.base.MvpView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Lei Chen on 2017/6/28.
 */

public class BillItemPresenter<V extends BillItemMvpView> extends BasePresenter<V> implements BillItemMvpPresenter<V> {

    private Bill bill;

    public BillItemPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public void onViewInitialized(Long id) {
        getDataManager().getBill(id);
    }
}
