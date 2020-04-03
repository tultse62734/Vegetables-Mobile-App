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
import com.example.flowermobile.models.Product;
import com.example.flowermobile.utils.ChangeValue;
import com.squareup.picasso.Picasso;
import java.util.List;
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.RecyclerViewHolder>{
    private Context mContext;
    private List<Product> mProductList;
    private OnItemClickListener mListener;
    public HomeAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_product_home,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        holder.mTxtNameProduct.setText(mProductList.get(position).getNameProduct() + "");
        holder.mTxtPrice.setText(ChangeValue.formatDecimalPrice(mProductList.get(position).getPriceProduct())+" /1kg");
        Picasso.get().load(mProductList.get(position).getImageProduct()).into(holder.mImgProduct);
        holder.mLnlRootHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener !=null){
                    mListener.OnClickItem(position);
                }
            }
        });
    }
    public  void  onItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mListener = mOnItemClickListener;
    }
    @Override
    public int getItemCount() {
        int count = (mProductList != null) ? mProductList.size() : 0;
        return count;
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLnlRootHome;
        ImageView mImgProduct;
        TextView mTxtNameProduct,mTxtPrice;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mLnlRootHome = itemView.findViewById(R.id.lnl_root_product);
            mImgProduct = itemView.findViewById(R.id.img_home_product);
            mTxtNameProduct = itemView.findViewById(R.id.txt_name_product);
            mTxtPrice = itemView.findViewById(R.id.txt_price_product);

        }
    }
    public  interface  OnItemClickListener{
        void OnClickItem(int pos);
    }
}
