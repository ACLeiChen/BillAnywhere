package com.example.leichen.billanywhere.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.onAttach(MainActivity.this);
        setUp();
    }

    @Override
    protected void setUp() {
        mPresenter.onViewInitialized();
    }

    @Override
    public void showAddingNewBillFragment() {

    }

    @Override
    public void openOldBillItemFragment() {

    }

    @Override
    public void refreshBills(List<Bill> bills) {

    }



}
