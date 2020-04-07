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
import com.example.flowermobile.models.Store;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoreAdapter  extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    private Context mContext;
    private List<Store> mStoreList;
    private OnItemClickListener mListener;
    public StoreAdapter(Context mContext, List<Store> mStoreList) {
        this.mContext = mContext;
        this.mStoreList = mStoreList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_layout_store,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTxtAddress.setText(mStoreList.get(position).getStoreAddress());
        holder.mTxtNameStore.setText(mStoreList.get(position).getStoreName());
        Picasso.get().load(mStoreList.get(position).getStoreImage()).into(holder.mImgStore);
        holder.mlnlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.getPosItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = (mStoreList != null) ? mStoreList.size() : 0;
        return count;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout mlnlRoot;
        private TextView mTxtNameStore;
        private TextView mTxtAddress;
        private ImageView mImgStore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mlnlRoot = itemView.findViewById(R.id.lnl_root_store);
            mTxtNameStore = itemView.findViewById(R.id.txt_name_store);
            mTxtAddress = itemView.findViewById(R.id.txt_address_store);
            mImgStore = itemView.findViewById(R.id.image_url_store);
        }
    }
    public  void OnItemClick(OnItemClickListener mClickListener){
        this.mListener = mClickListener;
    }
    public interface OnItemClickListener{
        void getPosItemClick(int pos);
    }
}
