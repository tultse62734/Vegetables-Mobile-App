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
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RecyclerViewHolder>{
    private Context mContext;
    private List<Category> categoryList;
    private OnItemClickListener mListener;
    public CategoryAdapter(Context mContext, List<Category> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_category_adapter,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        holder.mTxtCategoryName.setText(categoryList.get(position).getName());
        Picasso.get().load(categoryList.get(position).getUrl()).into(holder.mImgVCategoryImage);
        holder.mLnlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener !=null){
                    mListener.OnItemClick(position);
                }
            }
        });
    }
    public  void onClickItem(OnItemClickListener mOnItemClickListener){
        this.mListener = mOnItemClickListener;
    }
    @Override
    public int getItemCount() {
        int count = (categoryList != null) ? categoryList.size() : 0;
        return count;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtCategoryName;
        ImageView mImgVCategoryImage;
        LinearLayout mLnlRoot;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mImgVCategoryImage = itemView.findViewById(R.id.img_catelogy);
            mTxtCategoryName = itemView.findViewById(R.id.txt_cate_name);
            mLnlRoot = itemView.findViewById(R.id.lnl_root_categogy);

        }
    }
    public interface OnItemClickListener{
        void OnItemClick(int pos);
    }
}
