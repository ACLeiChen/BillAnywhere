package com.example.leichen.billanywhere.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.data.model.Bill;
import com.example.leichen.billanywhere.ui.BillItem.BillItemActivity;
import com.example.leichen.billanywhere.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView{

    @BindView(R.id.billsRecyclerView)
    public RecyclerView billsRecyclerView;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(MainActivity.this);
        setUp();
    }

    @Override
    protected void setUp() {
        billsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter.onViewInitialized();
    }

    @Override
    @OnClick(R.id.plusButton)
    public void openCreateNewBillActivity() {
    }

    //OnClick or OnItemClick?, needs more reading.
    @Override
    public void openBillItemActivity(Long id) {
        Intent intent = new Intent(this, BillItemActivity.class);
        intent.putExtra("BillId", id);
        startActivity(intent);
    }

    @Override
    public void refreshBills(List<Bill> bills) {
        billsRecyclerView.setAdapter(new BillsRecyclerViewAdapter(bills, (id -> openBillItemActivity(id))));
    }



}
