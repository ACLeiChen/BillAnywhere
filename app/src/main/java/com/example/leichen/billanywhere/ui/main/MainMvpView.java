package com.example.leichen.billanywhere.ui.main;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.base.MvpView;

import java.util.List;

/**
 * Created by Lei Chen on 2017/3/12.
 */

public interface MainMvpView extends MvpView{
    void onPlusButtonClick();
    void onOldBillItemClick();

    void refreshBills(List<Bill> bills);
}
