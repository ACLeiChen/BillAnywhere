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

    public interface OnItemClickListener {
        void onItemClick(Long id);
    }

    private final OnItemClickListener listener;

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

        public void setListener(Bill bill, OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(bill.getId());
                }
            });

        }
    }


    public BillsRecyclerViewAdapter(List<Bill> bills, OnItemClickListener listener){
        this.bills = bills;
        this.listener = listener;
    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_simple, parent, false);
        BillViewHolder billViewHolder = new BillViewHolder(v);
        return billViewHolder;
    }

    @Override
    public void onBindViewHolder(BillViewHolder billViewHolder, int position) {
        billViewHolder.timestamp.setImageResource(R.drawable.timestamp);
        billViewHolder.shopping_date.setText(bills.get(position).getShoppingDate().toString());
        billViewHolder.totalAmount.setText(bills.get(position).getTotalAmount().toString());
        billViewHolder.setListener(bills.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return bills.size();
    }
}
