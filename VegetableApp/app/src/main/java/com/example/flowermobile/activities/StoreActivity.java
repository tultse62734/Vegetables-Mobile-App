package com.example.flowermobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.flowermobile.R;
import com.example.flowermobile.adapters.StoreAdapter;
import com.example.flowermobile.models.Store;
import com.example.flowermobile.presenters.StorePresenter;
import com.example.flowermobile.utils.BundleString;
import com.example.flowermobile.utils.SharePreferenceUtils;
import com.example.flowermobile.views.StoreView;

import java.util.ArrayList;
import java.util.List;
public class StoreActivity extends AppCompatActivity implements StoreView {
    private StoreAdapter mStoreAdapter;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<Store> list;
    private StorePresenter mStorePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        initView();
        initData();
    }
    private void initView(){
        mToolbar = findViewById(R.id.toolbar_store);
        mRecyclerView = findViewById(R.id.rcv_store);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(StoreActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }
    private void initData(){
        list = new ArrayList<>();
        mStorePresenter = new StorePresenter(StoreActivity.this,this);
        mStorePresenter.getAllStore();
    }
    private void update(){
        if(mStoreAdapter == null){
            mStoreAdapter = new StoreAdapter(StoreActivity.this,list);
            mRecyclerView.setAdapter(mStoreAdapter);
            mStoreAdapter.OnItemClick(new StoreAdapter.OnItemClickListener() {
                @Override
                public void getPosItemClick(int pos) {
                    SharePreferenceUtils.saveStringSharedPreference(StoreActivity.this, BundleString.ADDRESSSTORE,list.get(pos).getStoreAddress());
                    Intent mIntent = new Intent(StoreActivity.this,HomeActivity.class);
                    startActivity(mIntent);
                }
            });
        }
        else {
            mStoreAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void getAllStoreSuccess(List<Store> mStoreList) {
        if(mStoreList !=null){
            list = mStoreList;
            update();
        }
    }

    @Override
    public void getFail(String messgae) {
        Toast.makeText(StoreActivity.this,"Không có đata",Toast.LENGTH_LONG).show();
    }
}
