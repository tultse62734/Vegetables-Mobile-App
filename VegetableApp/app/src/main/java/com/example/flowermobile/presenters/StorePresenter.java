package com.example.flowermobile.presenters;

import android.content.Context;

import com.example.flowermobile.models.Store;
import com.example.flowermobile.repositories.FloweRepositoty;
import com.example.flowermobile.repositories.FlowerRepositoryImpl;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.views.StoreView;

import java.util.List;

public class StorePresenter {
    private Context mContext;
    private StoreView mStoreView;
    private FloweRepositoty mFloweRepositoty;

    public StorePresenter(Context mContext, StoreView mStoreView) {
        this.mContext = mContext;
        this.mStoreView = mStoreView;
        this.mFloweRepositoty = new FlowerRepositoryImpl();
    }
    public void getAllStore(){
        this.mFloweRepositoty.getAllStore(mContext, new CallBackData<List<Store>>() {
            @Override
            public void onSucess(List<Store> stores) {
                mStoreView.getAllStoreSuccess(stores);
            }

            @Override
            public void onFail(String message) {
                mStoreView.getFail(message);
            }
        });
    }
}
