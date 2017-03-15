package com.example.leichen.billanywhere.ui.main;

import com.example.leichen.billanywhere.ui.base.MvpPresenter;

/**
 * Created by Lei Chen on 2017/3/12.
 */

public interface MainMvpPresenter<T extends MainMvpView> extends MvpPresenter<T> {
    void onPlusButtonClick();

    void onOldBillItemClick();

    void onViewInitialized();
}
