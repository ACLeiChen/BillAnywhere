package com.example.leichen.billanywhere.ui.BillItem;

import android.content.Context;
import android.content.Intent;

import com.example.leichen.billanywhere.ui.base.BaseActivity;

/**
 * Created by Lei Chen on 2017/6/19.
 */

public class BillItemActivity extends BaseActivity implements BillItemMvpView{
    @Override
    protected void setUp() {

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BillItemActivity.class);
        return intent;
    }
}
