package com.example.flowermobile.views;

import com.example.flowermobile.models.OrderHistory;

import java.util.List;

public interface GetAllOrderView {
    void getAllOrderSuccess(List<OrderHistory> mOrderHistoryList);
    void getAllOrderFail(String message);
}
