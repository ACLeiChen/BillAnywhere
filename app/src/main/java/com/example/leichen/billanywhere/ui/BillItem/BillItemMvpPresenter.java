package com.example.leichen.billanywhere.ui.BillItem;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.base.MvpPresenter;

/**
 * Created by Lei Chen on 2017/6/28.
 */

public interface BillItemMvpPresenter<V extends BillItemMvpView> extends MvpPresenter<V> {
    void getBill(Bill bill);

    void onViewInitialized(Long billId);
}
