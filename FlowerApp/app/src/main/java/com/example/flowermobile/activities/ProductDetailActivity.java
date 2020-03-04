package com.example.flowermobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowermobile.R;
import com.example.flowermobile.models.Product;
import com.example.flowermobile.presenters.CartPresenter;
import com.example.flowermobile.rooms.OrderItemEntities;
import com.example.flowermobile.utils.BundleString;
import com.example.flowermobile.utils.ChangeValue;
import com.example.flowermobile.views.AddToCartView;
import com.example.flowermobile.views.ShoppingCartView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.UUID;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener, AddToCartView {
    private double mTotal = 0;
    private int mQuantity = 1;
    private EditText mEdtQuantity;
    private Product mProduct;
    private  double price = 0;
    private TextView mProductPrice,mTxtName;
    private TextView mProductTotal;
    private ImageView mImgIncrease;
    private LinearLayout mLnlDismiss;
    private ImageView mImgDecrease,mImageProduct;
    private Button mBtnAddToCart;
    private TextView mTxtDesciption;
    private CartPresenter mCartPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initialView();
        initialData();
    }
    private void initialView(){
        mImageProduct = findViewById(R.id.img_product_image);
        mProductTotal = findViewById(R.id.product_total_price);
        mLnlDismiss = findViewById(R.id.lnl_dismiss);
        mLnlDismiss.setOnClickListener(this);
        mEdtQuantity = findViewById(R.id.edit_text_quantity_product);
        mEdtQuantity.setEnabled(false);
        mImgDecrease = findViewById(R.id.image_decrease_setting_order);
        mTxtName = findViewById(R.id.txt_product_name);
        mProductPrice = findViewById(R.id.txt_product_price);
        mImgIncrease = findViewById(R.id.image_increase_setting_order);
        mBtnAddToCart = findViewById(R.id.btn_add_to_cart);
        mTxtDesciption = findViewById(R.id.txt_description);
        mBtnAddToCart.setOnClickListener(this);
        mImgIncrease.setOnClickListener(this);
        mImgDecrease.setOnClickListener(this);
    }
    private void initialData(){
        Bundle bundle = getIntent().getExtras();
        mProduct = (Product)bundle.getSerializable(BundleString.PRODUCT_DETAIL);
        mTxtName.setText(mProduct.getNameProduct());
        Picasso.get().load(mProduct.getImageProduct()).into(mImageProduct);
        price = mProduct.getPriceProduct();
        mProductTotal.setText(ChangeValue.formatDecimalPrice(mProduct.getPriceProduct()));
        mProductPrice.setText(ChangeValue.formatDecimalPrice(mProduct.getPriceProduct()));
        mTxtDesciption.setText(mProduct.getDescription()+"");
        mEdtQuantity.setText("1");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_to_cart:
                addToCart();
                break;
            case R.id.lnl_dismiss:
                finish();
                break;
            case R.id.image_decrease_setting_order:
                buttonDecrease();
                break;
            case R.id.image_increase_setting_order:
                buttonIncrease();
                break;

        }
    }
    private void addToCart(){
            OrderItemEntities o = new OrderItemEntities();
            String orderId = UUID.randomUUID().toString();
            o.setOrderItemId(orderId);
            o.setTotal(mTotal);
            o.setQuality(mQuantity);
            o.setProduct(mProduct);
            mCartPresenter = new CartPresenter(ProductDetailActivity.this,getApplication(),this);
            mCartPresenter.addToCart(o);
    }
    private void buttonIncrease(){
        mQuantity++;
        mTotal =price* mQuantity;
        mEdtQuantity.setText(String.valueOf(mQuantity));
        mProductTotal.setText(ChangeValue.formatDecimalPrice((double) mTotal));
    }
    private void buttonDecrease(){
        mQuantity--;
        if (mQuantity < 1) {
            mQuantity = 1;
        }
        mTotal = price* mQuantity;
        mEdtQuantity.setText(String.valueOf(mQuantity));
        mProductTotal.setText(ChangeValue.formatDecimalPrice((double) mTotal));
    }
    @Override
    public void onSuccess() {
        Intent intent = new Intent(ProductDetailActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    @Override
    public void showListOrderItem(List<OrderItemEntities> item) {

    }
    @Override
    public void showError(String message) {
        Toast.makeText(ProductDetailActivity.this,"Add don't success",Toast.LENGTH_LONG).show();
    }
}
