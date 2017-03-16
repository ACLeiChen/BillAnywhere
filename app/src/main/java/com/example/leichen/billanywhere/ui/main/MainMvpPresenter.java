package com.example.leichen.billanywhere.ui.main;

import com.example.leichen.billanywhere.ui.base.MvpPresenter;

/**
 * Created by Lei Chen on 2017/3/12.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
    void onPlusButtonClick();

    void onOldBillItemClick();

    void onViewInitialized();
}
