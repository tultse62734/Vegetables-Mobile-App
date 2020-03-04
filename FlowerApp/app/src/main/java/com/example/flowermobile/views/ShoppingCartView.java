package com.example.flowermobile.views;

import com.example.flowermobile.rooms.OrderItemEntities;

import java.util.List;


public interface ShoppingCartView extends BaseView {
    void showListOrderItem(List<OrderItemEntities> orderItemEntities);

}
