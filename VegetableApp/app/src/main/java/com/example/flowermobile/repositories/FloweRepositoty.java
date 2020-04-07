package com.example.flowermobile.repositories;

import android.content.Context;

import com.example.flowermobile.models.Account;
import com.example.flowermobile.models.Category;
import com.example.flowermobile.models.Order;
import com.example.flowermobile.models.OrderHistory;
import com.example.flowermobile.models.Product;
import com.example.flowermobile.models.Store;
import com.example.flowermobile.models.User;
import com.example.flowermobile.utils.CallBackData;

import java.util.List;

public interface FloweRepositoty {
    void login (Context context,String username, String password, CallBackData<Account> callBackData);
    void getAllCategory(Context context, CallBackData<List<Category>> callBackData);
    void getAllProduct(Context context, CallBackData<List<Product>>mCallBackData);
    void getProductByCateId(Context context,int cateId,CallBackData<List<Product>> callBackData);
    void createOrder(Context context, Order order,CallBackData<String> callBackData);
    void getAllStore(Context mContext,CallBackData<List<Store>>callBackData);
    void getAllOrder(Context mContext, CallBackData<List<OrderHistory>> callBackData);
}
