package com.example.flowermobile.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowermobile.R;
import com.example.flowermobile.rooms.OrderItemEntities;
import com.example.flowermobile.utils.ChangeValue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<OrderItemEntities> mListItem;
    private OnItemClickedListener mListener;

    public ShopCartAdapter(Context mContext, List<OrderItemEntities> mListItem) {
        this.mContext = mContext;
        this.mListItem = mListItem;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_shop_cart,viewGroup,false);
        return new RecyclerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder,final int position) {
        Picasso.get().load(mListItem.get(position).getProduct().getImageProduct()).into(holder.imgProductImage);
        holder.txtName.setText(mListItem.get(position).getProduct().getNameProduct());
        holder.txtPrice.setText(ChangeValue.formatDecimalPrice((double) mListItem.get(position).getTotal()));
        holder.txtQuanlity.setText("Số lượng : " +mListItem.get(position).getQuality()+"");
        holder.lnlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClicked(position);
            }
        });
    }
    public void notifyChange(List<OrderItemEntities> orderItemEntities){
        mListItem = new ArrayList<>();
        mListItem = orderItemEntities;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        int count = (mListItem != null) ? mListItem.size() : 0;
        return count;
    }
    public void removeItem(int position) {
        mListItem.remove(position);
        notifyItemRemoved(position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtPrice,txtQuanlity;
        ImageView imgProductImage;
        LinearLayout lnlRoot;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imgProductImage = (ImageView) itemView.findViewById(R.id.img_product_shopping);
            txtName = (TextView) itemView.findViewById(R.id.txt_product_name_shopping);
            txtPrice = (TextView)itemView.findViewById(R.id.txt_product_price_shopping);
            txtQuanlity  = itemView.findViewById(R.id.txt_product_quality_shopping);
            lnlRoot = itemView.findViewById(R.id.lnl_row_product_shop_cart);
        }
    }
    public interface OnItemClickedListener{
        void onItemClicked(int position);
    }
    public void setOnItemClickedListener(OnItemClickedListener listener){
        mListener= listener;
    }
}
