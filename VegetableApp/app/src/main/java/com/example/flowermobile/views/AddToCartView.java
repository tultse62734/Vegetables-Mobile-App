package com.example.flowermobile.views;

import com.example.flowermobile.rooms.OrderItemEntities;

import java.util.List;

public interface AddToCartView extends BaseView {
    void onSuccess();
    void showListOrderItem(List<OrderItemEntities> item);
}
