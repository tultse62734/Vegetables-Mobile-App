package com.example.flowermobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowermobile.R;
import com.example.flowermobile.models.OrderHistory;

import java.util.List;

public class OrderHistoryAdpapter  extends RecyclerView.Adapter<OrderHistoryAdpapter.ViewHolder>{
    private Context mContext;
    private List<OrderHistory> mOrderHistoryList;

    public OrderHistoryAdpapter(Context mContext, List<OrderHistory> mOrderHistoryList) {
        this.mContext = mContext;
        this.mOrderHistoryList = mOrderHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_layout_order_history,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mDateOrder.setText(mOrderHistoryList.get(position).getOrderDate());
        holder.mTxtPriceOrder.setText(mOrderHistoryList.get(position).getTotal() + "");
        holder.mTxtAddress.setText(mOrderHistoryList.get(position).getNotes());
    }

    @Override
    public int getItemCount() {
        int count = (mOrderHistoryList != null) ? mOrderHistoryList.size() : 0;
        return count;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mDateOrder,mTxtPriceOrder,mTxtAddress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mDateOrder = itemView.findViewById(R.id.txt_date_order);
            mTxtAddress = itemView.findViewById(R.id.txt_address_order);
            mTxtPriceOrder  = itemView.findViewById(R.id.txt_price_order);
        }
    }
}
