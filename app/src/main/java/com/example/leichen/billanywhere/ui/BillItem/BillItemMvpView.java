package com.example.leichen.billanywhere.ui.BillItem;

import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.base.MvpView;

/**
 * Created by Lei Chen on 2017/6/19.
 */

interface BillItemMvpView extends MvpView {
    void renderBill(Bill bill);
}
