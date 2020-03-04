package com.example.flowermobile.presenters;

import android.content.Context;

import com.example.flowermobile.models.Order;
import com.example.flowermobile.repositories.FloweRepositoty;
import com.example.flowermobile.repositories.FlowerRepositoryImpl;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.views.OrderView;

public class OrderPresenter {
    private Context context;
    private FloweRepositoty mFloweRepositoty;
    private OrderView mOrderView;

    public OrderPresenter(Context context, OrderView mOrderView) {
        this.context = context;
        this.mOrderView = mOrderView;
        this.mFloweRepositoty = new FlowerRepositoryImpl();
    }
    public  void order(Order mOrder){
        this.mFloweRepositoty.createOrder(context, mOrder, new CallBackData<String>() {
            @Override
            public void onSucess(String s) {
                mOrderView.orderSuccess(s);
            }
            @Override
            public void onFail(String message) {
                mOrderView.orderFail(message);
            }
        });
    }
}
