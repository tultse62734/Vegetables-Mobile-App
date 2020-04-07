package com.example.flowermobile.presenters;

import android.content.Context;

import com.example.flowermobile.models.OrderHistory;
import com.example.flowermobile.repositories.FloweRepositoty;
import com.example.flowermobile.repositories.FlowerRepositoryImpl;
import com.example.flowermobile.utils.CallBackData;
import com.example.flowermobile.views.GetAllOrderView;

import java.util.List;

public class GetAllOrderPresenter {
    private Context mContext;
    private GetAllOrderView mGetAllOrderView;
    private FloweRepositoty mFloweRepositoty;

    public GetAllOrderPresenter(Context mContext, GetAllOrderView mGetAllOrderView) {
        this.mContext = mContext;
        this.mGetAllOrderView = mGetAllOrderView;
        this.mFloweRepositoty = new FlowerRepositoryImpl();
    }
    public void getAllStore(){
        this.mFloweRepositoty.getAllOrder(mContext, new CallBackData<List<OrderHistory>>() {
            @Override
            public void onSucess(List<OrderHistory> orderHistories) {
                mGetAllOrderView.getAllOrderSuccess(orderHistories);
            }

            @Override
            public void onFail(String message) {
                    mGetAllOrderView.getAllOrderFail(message);
            }
        });
    }
}
