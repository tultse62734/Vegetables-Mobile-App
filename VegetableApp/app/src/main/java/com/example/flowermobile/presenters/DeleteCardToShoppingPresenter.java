package com.example.flowermobile.presenters;

import android.app.Application;
import android.content.Context;

import com.example.flowermobile.rooms.management.OrderItemManagement;
import com.example.flowermobile.views.DeleteCardView;

public class DeleteCardToShoppingPresenter {
    private Context context;
    private Application mApplication;
    private OrderItemManagement orderItemManagement;

    private DeleteCardView mDeleteCardView;
    public DeleteCardToShoppingPresenter(Context context, Application mApplication, DeleteCardView mView) {
        this.context = context;
        this.mApplication = mApplication;
        this.orderItemManagement = new OrderItemManagement(mApplication);
        this.mDeleteCardView = mView;
    }
    public void deleteAllOrder(){
        orderItemManagement.deleteAllOrder();
        mDeleteCardView.deleteAllCard("thành công");
    }

}
