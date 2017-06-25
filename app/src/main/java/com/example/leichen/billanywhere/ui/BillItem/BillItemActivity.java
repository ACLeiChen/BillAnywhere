package com.example.leichen.billanywhere.ui.BillItem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BillItemActivity extends BaseActivity implements BillItemMvpView {

    private Long billId;

    @BindView(R.id.billID)
    public TextView billIdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_item);

        setUnBinder(ButterKnife.bind(this));

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        billId = intent.getLongExtra("BillId", 0);
        setUp();
    }

    @Override
    protected void setUp() {
        billIdView.setText("Bill ID is : " + billId);
    }

    protected void onResume()
    {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }
}
