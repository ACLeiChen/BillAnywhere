package com.example.leichen.billanywhere.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainMvpView{

    @BindView(R.id.billsRecyclerView)
    public RecyclerView billsRecyclerView;

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
        billsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //billsRecyclerView.setAdapter();
        mPresenter.onViewInitialized();
    }

    @Override
    public void onPlusButtonClick() {
    }

    @Override
    public void onOldBillItemClick() {

    }

    @Override
    public void refreshBills(List<Bill> bills) {

    }



}
