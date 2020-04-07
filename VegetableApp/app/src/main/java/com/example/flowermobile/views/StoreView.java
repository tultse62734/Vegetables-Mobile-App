package com.example.flowermobile.views;

import com.example.flowermobile.models.Store;

import java.util.List;

public interface StoreView {
    void getAllStoreSuccess(List<Store> mStoreList);
    void getFail(String messgae);
}
