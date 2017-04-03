package com.example.leichen.billanywhere.ui.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leichen.billanywhere.R;
import com.example.leichen.billanywhere.data.model.Bill;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Chen on 2017/4/3.
 */

public class BillsRecyclerViewAdapter extends RecyclerView.Adapter<BillsRecyclerViewAdapter.BillViewHolder> {

    private List<Bill> bills;

    public static class BillViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bill_simple)
        CardView billSimple;

        @BindView(R.id.shopping_date)
        TextView shopping_date;

        @BindView(R.id.timestamp)
        ImageView timestamp;

        @BindView(R.id.total_amount)
        TextView totalAmount;

        public BillViewHolder(View billView) {
            super(billView);
            ButterKnife.bind(this, billView);
        }
    }

    public BillsRecyclerViewAdapter(List<Bill> bills){
        this.bills = bills;
    }


    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_simple, parent, false);
        BillViewHolder billViewHolder = new BillViewHolder(v);
        return billViewHolder;
    }

    @Override
    public void onBindViewHolder(BillViewHolder billViewHolder, int position) {
        billViewHolder.shopping_date.setText(bills.get(position).getShopping_date().toString());
        billViewHolder.timestamp.setImageResource(R.drawable.timestamp);
        //billViewHolder.totalAmount.setText(bills.get(position).getTotoal_amount);
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }
}
