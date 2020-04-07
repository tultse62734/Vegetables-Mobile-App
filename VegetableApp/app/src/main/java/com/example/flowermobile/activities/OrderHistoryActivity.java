package com.example.flowermobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.flowermobile.R;
import com.example.flowermobile.adapters.OrderHistoryAdpapter;
import com.example.flowermobile.models.OrderHistory;
import com.example.flowermobile.presenters.GetAllOrderPresenter;
import com.example.flowermobile.views.GetAllOrderView;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity implements GetAllOrderView {
    private Toolbar mToolbar;
    private OrderHistoryAdpapter mOrderHistoryAdpapter;
    private RecyclerView mRecyclerView;
    private List<OrderHistory> historyList;
    private GetAllOrderPresenter mGetAllOrderPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        initialView();
        initialData();
    }
    private void initialView(){
        mToolbar = findViewById(R.id.toolbar_history_order);
        mToolbar.setNavigationIcon(R.mipmap.ic_left_chevron);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerView = findViewById(R.id.rcv_history_order);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(OrderHistoryActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }
    private void initialData(){
        historyList = new ArrayList<>();
        mGetAllOrderPresenter = new GetAllOrderPresenter(OrderHistoryActivity.this,this);
        mGetAllOrderPresenter.getAllStore();
    }
    private void update(){
        if(mOrderHistoryAdpapter ==null){
            mOrderHistoryAdpapter = new OrderHistoryAdpapter(OrderHistoryActivity.this,historyList);
            mRecyclerView.setAdapter(mOrderHistoryAdpapter);
        }
        else {
                mOrderHistoryAdpapter.notifyDataSetChanged();
        }
    }
    @Override
    public void getAllOrderSuccess(List<OrderHistory> mOrderHistoryList) {
        if(mOrderHistoryList !=null){
            historyList= mOrderHistoryList;
            update();
        }
    }
    @Override
    public void getAllOrderFail(String message) {

    }
}
