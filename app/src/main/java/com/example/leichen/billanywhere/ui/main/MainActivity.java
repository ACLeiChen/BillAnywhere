package com.example.leichen.billanywhere.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.data.db.model.Bill;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainMvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showAddingNewBillFragment() {

    }

    @Override
    public void openOldBillItemFragment() {

    }

    @Override
    public void refreshBills(List<Bill> billList) {

    }
}
