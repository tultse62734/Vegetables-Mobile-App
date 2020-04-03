package com.example.flowermobile.activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.flowermobile.R;
import com.example.flowermobile.adapters.ShopCartAdapter;
import com.example.flowermobile.adapters.SwipeToDeleteCallback;
import com.example.flowermobile.models.Order;
import com.example.flowermobile.presenters.InformationAccountPresenter;
import com.example.flowermobile.presenters.OrderPresenter;
import com.example.flowermobile.presenters.ShoppingCartPresenter;
import com.example.flowermobile.rooms.OrderItemEntities;
import com.example.flowermobile.utils.ChangeValue;
import com.example.flowermobile.utils.SharePreferenceUtils;
import com.example.flowermobile.views.OrderView;
import com.example.flowermobile.views.ShoppingCartView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class ShoppingCartActivity extends AppCompatActivity implements ShoppingCartView, View.OnClickListener, OrderView {
    private RecyclerView mRcvShopCart;
    private List<OrderItemEntities> mListOrder;
    private ShopCartAdapter mShopCartApdapter;
    private ShoppingCartPresenter mPresenter;
    private LinearLayout mBtnPayment;
    private float mTotal=0;
    private OrderPresenter mOrderPresenter;
    private int userId;
    private TextView mTxtTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        initialView();
        initialData();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getAllOrderItem();
    }
    private void initialView(){
        mRcvShopCart = findViewById(R.id.rcv_shopping_cart);
        mBtnPayment = findViewById(R.id.lnl_button_payment);
        mTxtTotal = findViewById(R.id.product_total_shopping);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(ShoppingCartActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcvShopCart.setLayoutManager(layoutManager);
    }
    private void initialData(){
        userId = SharePreferenceUtils.getIntSharedPreference(ShoppingCartActivity.this,"UserId");
        mBtnPayment.setOnClickListener(this);
        mPresenter = new ShoppingCartPresenter(ShoppingCartActivity.this,getApplication(),this);
        mPresenter.getAllOrderItem();
    }
    public void updateUI(){
          if(mShopCartApdapter == null){
              mShopCartApdapter = new ShopCartAdapter(ShoppingCartActivity.this,mListOrder);
              mRcvShopCart.setAdapter(mShopCartApdapter);
              mShopCartApdapter.setOnItemClickedListener(new ShopCartAdapter.OnItemClickedListener() {
                  @Override
                  public void onItemClicked(int position) {

                  }
              });
          }
          else {
              mShopCartApdapter.notifyChange(mListOrder);
          }
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.lnl_button_payment:
                paymentOrder();
            break;
        }
    }
    public void enableSwipeToDeleteAndUndo( final List<OrderItemEntities> mListOrder) {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                final int position = viewHolder.getAdapterPosition();
                mShopCartApdapter.removeItem(position);
                mPresenter.removeItemCard(mListOrder.get(position));
            }
        };
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(mRcvShopCart);
    }
    public void costTotal(List<OrderItemEntities> mListOrder){
        for (int i = 0; i < mListOrder.size(); i++) {
            mTotal  += mListOrder.get(i).getTotal();
        }
        mTxtTotal.setText(ChangeValue.formatDecimalPrice((double)mTotal/2));
    }
    private void paymentOrder(){
        mOrderPresenter = new OrderPresenter(ShoppingCartActivity.this,this);
        Order order = new Order();
        order.setUserId(userId);
        order.setTotal(mTotal/2);
        order.setNotes("Khuyến mãi 50%");
        Calendar cal = Calendar.getInstance();
         Date date = cal.getTime();
         SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        order.setOrderDate(sdf.format(date));
        mOrderPresenter.order(order);
    }
    @Override
    public void showListOrderItem(List<OrderItemEntities> orderItemEntities) {
            if(orderItemEntities.size()!=0){
                mListOrder = orderItemEntities;
                updateUI();
                costTotal(orderItemEntities);
                enableSwipeToDeleteAndUndo(mListOrder);

            }
    }
    @Override
    public void showError(String message) {

    }

    @Override
    public void orderSuccess(String success) {
        Intent intent = new Intent(ShoppingCartActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void orderFail(String messgae) {

    }
}
