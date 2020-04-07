package com.example.flowermobile.presenters;

import android.app.Application;
import android.content.Context;

import com.example.flowermobile.rooms.OrderItemEntities;
import com.example.flowermobile.rooms.management.OrderItemManagement;
import com.example.flowermobile.views.AddToCartView;
import com.example.flowermobile.views.DeleteCardView;
import com.example.flowermobile.views.UpdateCardView;
import java.util.List;
public class CartPresenter {
   private Context context;
   private Application mApplication;
   private OrderItemManagement orderItemManagement;
   private AddToCartView view;
   private UpdateCardView mView;
   private DeleteCardView mDeleteCardView;

    public CartPresenter(Context context, Application application, AddToCartView view) {
        this.context = context;
        this.mApplication = application;
        this.orderItemManagement = new OrderItemManagement(application);
        this.view = view;
    }
    public CartPresenter(Context context, Application mApplication, UpdateCardView mView) {
        this.context = context;
        this.mApplication = mApplication;
        this.orderItemManagement = new OrderItemManagement(mApplication);
        this.mView = mView;
    }

    public void addToCart(OrderItemEntities o){
        orderItemManagement.addOrderItem(o);
        view.onSuccess();
    }
    public void getListOrder(){
        orderItemManagement.getOrderItem(new OrderItemManagement.DataCallBack() {
            @Override
            public void onSuccess(List<OrderItemEntities> list) {
                view.showListOrderItem(list);
            }

            @Override
            public void onFail(String message) {
                view.showError(message);
            }
        });
    }
    public  void updateToCart(OrderItemEntities orderItemEntities){
        orderItemManagement.updateOrder(orderItemEntities);
        mView.updateCardSuccess();
    }

}
