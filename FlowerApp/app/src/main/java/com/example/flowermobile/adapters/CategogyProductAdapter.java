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
import com.example.flowermobile.models.Category;
import com.example.flowermobile.models.Product;
import com.example.flowermobile.utils.ChangeValue;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategogyProductAdapter extends RecyclerView.Adapter<CategogyProductAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<Product> categoryProductList;
    private OnItemClickListener mListener;
    public CategogyProductAdapter(Context mContext, List<Product> categoryProductList) {
        this.mContext = mContext;
        this.categoryProductList = categoryProductList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_product_cate,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        holder.mTxtCategoryNameProdcut.setText(categoryProductList.get(position).getNameProduct()+"");
        Picasso.get().load(categoryProductList.get(position).getImageProduct()).into(holder.mImgVCategoryImageProduct);
        holder.mTxtPriceProductCate.setText(ChangeValue.formatDecimalPrice(categoryProductList.get(position).getPriceProduct() )+" /1 kg");
        holder.mLnlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.OnItemClick(position);
                }
            }
        });
    }
    public void onItemClick(OnItemClickListener onItemClickListener){
        this.mListener = onItemClickListener;
    }
    @Override
    public int getItemCount() {
        int count = (categoryProductList != null) ? categoryProductList.size() : 0;
        return count;
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtCategoryNameProdcut,mTxtPriceProductCate;
        ImageView mImgVCategoryImageProduct;
        LinearLayout mLnlRoot;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mImgVCategoryImageProduct = itemView.findViewById(R.id.img_cate_product);
            mTxtCategoryNameProdcut = itemView.findViewById(R.id.txt_cate_product);
            mTxtPriceProductCate = itemView.findViewById(R.id.txt_price_cate_product);
            mLnlRoot = itemView.findViewById(R.id.lnl_root_categogy_product);
        }
    }
    public interface  OnItemClickListener{
        void OnItemClick(int pos);
    }
}
