package com.example.leichen.billanywhere.ui.main;

import com.example.leichen.billanywhere.data.model.Bill;

import java.util.List;

/**
 * Created by Lei Chen on 2017/3/12.
 */

public interface MainMvpView {
    void showAddingNewBillFragment();
    void openOldBillItemFragment();

    void refreshBills(List<Bill> billList);
}
